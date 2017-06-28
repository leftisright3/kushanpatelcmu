@echo on
call mvn clean install
echo \n**************DEPLOYING TO TOMCAT ***************** \n
copy C:\Development\kushanpatelcmu\web\target\kush.war C:\Development\apache-tomee-1.7.4-plus\apache-tomee-plus-1.7.4\webapps\ 




