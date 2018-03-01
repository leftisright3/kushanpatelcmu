package practice.model.Treehouse_Practice; /**
 * Created by Amar on 2/19/2018.
 */

import java.io.Console;
import java.util.Scanner;

public class Introduction {
/*
This program simply prompts the user for their name and asks if they're doing well,  and outputs a statement based on their response.

*/


/*
Topics covered:
-  receiving input
- outputting Strings
- conditions

 */


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        int age = 0;
        System.out.println("Are you doing well today? \nPlease answer yes or no");

        String status = scanner.nextLine();

        while  (!status.equals("yes") && (!status.equals("no"))) {
            System.out.println("Please answer yes or no");
            status = scanner.nextLine();

        } // loop for improper input

        String statusResponse = "";
        if (status.equals("yes")) {
            statusResponse = "I am glad you are doing well";


        } else if (status.equals("no")) {
            statusResponse = "I'm sorry to hear that, I hope your day gets better";


        }// //end statusResponse setter

        System.out.printf("Hello, %s \n%s", name, statusResponse);



        System.out.println("\nHow old are you?\n");

            while (age == 0){


            try {age =  Integer.parseInt(scanner.nextLine());}

            catch (NumberFormatException e) {
            System.out.print("you didn't enter a number.try again \n How old are you?");


            }}

        System.out.printf("You are %s years old", Integer.toString(age));


    } //end main method

} //end class
