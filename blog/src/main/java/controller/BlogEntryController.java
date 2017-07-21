package controller;

import persistence.model.BlogEntry;
import persistence.service.BlogEntryDataService;
import rest.BlogEntryTO;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by kushan on 6/19/17.
 */
public class BlogEntryController {

    @Inject
    BlogEntryDataService beds;

    public List<BlogEntry> getAllEntries(){
        return beds.getAllEntries();
    }


//    public void addNewBlogEntry(String description, String location) {
//        BlogEntry entry = new BlogEntry();
//        entry.setDescription(description);
//        entry.setLocation(location);
//        beds.persistBlogEntry(entry);
//    }

    public void addNewBlogEntry(BlogEntryTO blogEntryTO) {
        BlogEntry entry = new BlogEntry();
        entry.setLocation(blogEntryTO.location);
        entry.setDescription(blogEntryTO.description);
        entry.setBlogData(blogEntryTO.blogData);
        entry.setCreatedByUid(blogEntryTO.createdByUid);
        entry.setModifiedByUid(blogEntryTO.modifiedByUid);

        beds.persistBlogEntry(entry);

    }

    public void editBlogEntry(BlogEntryTO blogEntryTO){
        BlogEntry entry = beds.selectBlogEntry(blogEntryTO.id);
        entry.setLocation(blogEntryTO.location);
        entry.setDescription(blogEntryTO.description);
        entry.setBlogData(blogEntryTO.blogData);
        entry.setModifiedByUid(blogEntryTO.modifiedByUid);
        beds.updateBlogEntry(entry);
    }

    public BlogEntry getLatestEntry() {
        return beds.getLatestEntry();
    }

    public void deleteBlogEntry(Long blogEntryId) {
        beds.deleteBlogEntry(blogEntryId);
    }


    public BlogEntryTO counterPractice(){

        BlogEntryTO practiceTO = new BlogEntryTO();
        practiceTO.id = 3434343434L;

        return practiceTO;


//        String returnString = "Here is a string \n";
//        int counter = 10;
//
//        returnString += "The counter has been initialized at " + counter +"\n";
//
//
//        while (counter >=0 ){
//            returnString +=("The Counter is at "+ counter)+ "\n";
//            counter--;
//
//
//        }
//        returnString +="\n";
//        returnString +="Let's print all the even numbers before 100 \n";
//
//        for(int i = 0; i <=100;i++){
//            if (i%2 == 0){
//                returnString += i +" is an even number \n";
//            }
//
//        }




    }//end counterPractice



}