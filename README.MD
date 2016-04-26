Prerequisite
---------------
Make sure you have installed Maven and jdk1.8,  JAVA_HOME is set correctly.
You also need database to run this application. This application was tested on Oracle.
Recommend IDE is IntelliJ if you want to import the project.

How to run
---------------
Step 1: Prepare DB
---------------
1 Create city table in database and insert data, take oracle as example, script as follow:
   CREATE TABLE  "CITY"
   (	"ID" NVARCHAR2(32) NOT NULL ENABLE,
	"NAME" NVARCHAR2(32) NOT NULL ENABLE
   ) ;

   INSERT INTO  CITY(ID,NAME) VALUES('6619279','Sydney');
   INSERT INTO  CITY(ID,NAME) VALUES('7839805','Melbourne');
   INSERT INTO  CITY(ID,NAME) VALUES('7839791','Wollongong');

2 Change data source configuration to a working DB in src\main\resources\application.yaml .
 datasource:
    driver-class-name: oracle.jdbc.driver.OracleDriver
    url: jdbc:oracle:thin:@//localhost:1521/i10920
    username: i1
    password: i1

 Step 2: Compile and run
 ---------------
  1 Open dos window
  2 Change to root directory and run 'mvn clean install', you will get Ione-0.0.1-SNAPSHOT.jar in Ione\target directory.
  3 Change to Ione\target directory and run 'java -jar  Ione-0.0.1-SNAPSHOT.jar'
  4 Open browser and access http://localhost:8080/
