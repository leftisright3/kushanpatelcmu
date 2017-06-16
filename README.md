# kushanpatelcmu
My Website

Software to Install:
SourceTree - https://www.sourcetreeapp.com/ Note - You need to create an Atlassian Account
TomEE Plus 1.7.4 - http://repo.maven.apache.org/maven2/org/apache/openejb/apache-tomee/1.7.4/apache-tomee-1.7.4-plus.zip
Maven - http://apache.mirrors.pair.com/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.zip
IntelliJ (or Eclipse) - Google it
Git - Follow this tutorial to install on Windows - https://www.atlassian.com/git/tutorials/install-git#windows
JDK 1.8

You need to have Maven, Git, and JDK 1.8 installed at a minimum in order to pull the code and build it.
You will need to have Tomcat installed to deploy the build to the server.

Note - After install Maven and JDK, you will need to add the JAVA_HOME and M2_HOME environment variables. They also need to be added to the PATH. Please Google "Add environment variable windows". 

1. Clone the repository

git clone https://github.com/leftisright3/kushanpatelcmu.git

2. Checkout the develop branch

git checkout develop

3. Navigate to the root directory of the code base (kushanpatelcmu) and run the Maven build command:

mvn clean install

** This will compile the java code and package up the HTML, CSS, Javascript, and Java class files into what's called a .war file.
 
4. Copy the .war file from the target directory to the webapps directory of where you install Tomcat

** On a Unix system, the command looks something like the following:

cp workspace/kushanpatelcmu/web/target/services.war /opt/apache-tomee-plus-1.7.4/webapps/

5. Start the Tomcat server

/opt/apache-tomee-plus-1.7.4/bin/startup.sh

6. Navigate to http://localhost:8080/kushanpatelcmu

** You should see a welcome page

7. Test the REST service by navigating to:

http://localhost:8080/services/rest/methodPath/testing?queryParam=services

You should see a response with "testing services".