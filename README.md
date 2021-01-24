# VMWAssignment


For building and running the application below is needed:
JDK 1.8
Maven 3

 Building the tool:
 From the project path where pom.xml is present enter the below command.
	mvn clean install

Technology stack

Server - Backend
JDK
Spring Boot
Maven
JSON Web Token

Running the application with Maven
It can use the Spring Boot Maven plugin like so:

$ git clone https://github.com/AbhinavSinha12/VMWAssignment.git
$ cd Spring-Boot-Application-Template
$ mvn spring-boot:run

Running the application with CommandLine

java -jar /Users/abhinav/.m2/repository/com/vmware/assignment/assignment/0.0.1-SNAPSHOT/assignment-0.0.1-SNAPSHOT.jar

Running the application with IDE

Alternatively it can be downloaded as zip file from git and to execute the main method in the VmWareAssignmentApplication  class from the IDE.
Download the zip or clone the Git repository.
Unzip the zip file.
Open Command Prompt and Change directory (cd) to folder containing pom.xml
Open Eclipse/IntelliJ
File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
Select the project
Choose the Spring Boot Application file (search for @SpringBootApplication)
Right Click on the file and Run as Java Application

Running the application with Executable JAR
The code can also be built into a jar and then executed/run. Once the jar is built, run the jar by double clicking on it or by using the command

$ git clone https://github.com/AbhinavSinha12/VMWAssignment.git
$ cd VMWareAssignment
$ mvn package -DskipTests
$ java -jar target/assignment-0.0.1-SNAPSHOT.jar





Testing API

Testing with Postman Runner


PostmanCollection

What is does ?

This service allows to upload sample file which can be processed at the server to upload the data in the database. It returns task id associated with the process. User later can query the same task id and get the status of the task.


FileStorageService:
This service is used to upload the files on the server. 

TaskStatusService:
This service is used to create an entry in the task table with all the features related with it. 

Quartz Scheduler:

BatchSchedulerJob  is responsible for running the job at regular interval and query the task table to check if there is ay new task id with running status “submitted”. It process the pending task and process those files.  

Spring Batch

SpringBatchConfig class is responsible for setting the spring container with necessary information to execute the batch process to parse the file and upload the data in database.


Spring Batch Working



Docker Container Initialiser.

To create a docker container.

Create docker file 
Create starter file to run the associated jar
	java -jar /opt/abhinav/app/VMW/assignment-0.0.1-SNAPSHOT.jar

Write build.sh in the VMWareAssignment folder.
Create file run.sh in the target folder and write the followingdocker run --restart=always --name vmw-app  -p 8080:8080 -d   vmw:1.0.0 

Load the docker image load <vmw.tar.gz
