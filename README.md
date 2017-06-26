# Development Environment Setup


### Software to Install:
* SourceTree - https://www.sourcetreeapp.com/ Note - You need to create an Atlassian Account
* TomEE Plus 1.7.4 - http://repo.maven.apache.org/maven2/org/apache/openejb/apache-tomee/1.7.4/apache-tomee-1.7.4-plus.zip
* Maven - http://apache.mirrors.pair.com/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.zip
* IntelliJ (or Eclipse) - Google it
* Git - https://www.atlassian.com/git/tutorials/install-git#windows
* JDK 1.8
* Postgres 9.6 or greater

You need to have Maven, Git, and JDK 1.8 installed at a minimum in order to pull the code and build it.
You will need to have Tomcat installed to deploy the build to the server.

Note - After install Maven and JDK, you will need to add the JAVA_HOME, MAVEN_HOME, and M2_HOME environment variables. They also need to be added to the PATH. Please Google "Add environment variable windows". 

### 1. Clone the repository

        git clone https://github.com/leftisright3/kushanpatelcmu.git

### 2. Checkout the develop branch

        git checkout develop

### 3. Navigate to the root directory of the code base (kushanpatelcmu) and run the Maven build command:

        mvn clean install

* This will compile the java code and package up the HTML, CSS, Javascript, and Java class files into what's called a .war file.
 
### 4. Copy the .war file from the target directory to the webapps directory of where you install Tomcat

* On a Unix system, the command looks something like the following:

    `cp workspace/kushanpatelcmu/web/target/services.war /opt/apache-tomee-plus-1.7.4/webapps/`

### 5. Start the Tomcat server

* Unix \
        `/opt/apache-tomee-plus-1.7.4/bin/startup.sh`

* Windows \
        `{tomcat-root}\bin\startup.bat`

### 6. Navigate to home page

        http://localhost:8080/kush

* You should see a welcome page (AKA The Master)

### 7. Test the REST service by navigating to:

        http://localhost:8080/kush/rest/methodPath/testing?queryParam=services

* You should see a response with "testing services".

## Set up Postgres Database and configure connectivity
* The assumption here is that you've downloaded and installed Postgres 9.6 or higher

### 8. Start database server

* Unix \
    `pg_ctl -D /usr/local/var/postgres -l /usr/local/var/postgres/server.log start`

### 9. Create the database

* Unix \
    `createdb website_data`
    
### 10. Create the tables

* Unix 

    `psql website_data`
    
    `create table blog_entry (id bigserial not null,` \
       `blog_data bytea,` \
       `created_by_uid character varying(255) NOT NULL,` \
       `created_time timestamp without time zone,` \
       `modified_by_uid character varying(255) NOT NULL,` \
       `modified_time timestamp without time zone,` \
       `description character varying(512),` \
       `location character varying(255)` \
       `CONSTRAINT blog_entry_pkey PRIMARY KEY (id)` \
       `);`

### 11. Configure Tomcat JDBC resource

* Edit the `{tomcat-root}/conf/tomee.xml` file to include the following:

    `<Resource  id="WebsiteDataStore" type="DataSource">` \
               `JdbcDriver org.postgresql.Driver` \
               `JdbcUrl jdbc:postgresql://127.0.0.1:5432/website_data` \
               `UserName kushan` \
               `JtaManaged true` \
               `TestWhileIdle true` \
               `InitialSize 5` \
    `</Resource>`
    
* Be sure to restart the server

    `${tomcat-root}/bin/shutdown.sh` \
    `${tomcat-root}/bin/startup.sh`
       
### 12. Test the DB connectivity

* In a browser, navigate to 

    `http://localhost:8080/kush/rest/entries`

* You should see an empty array as a response. If so, your DB is configured correctly.