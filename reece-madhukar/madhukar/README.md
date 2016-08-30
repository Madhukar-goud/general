## Synopsis
+ The project uses Java 8 Streams, so it is required that you have Java 8

+ The application was developed on Windows machine. If you want to run it on Linux or other OS, you may need to modify some of the path variables for file related paths.
 
## Required JARs:
+ Uses LOG4J2 - As it is better than logback, slf4j simple or older log4j
+ Added Junit related JAR 
+ Added Cobertura plugin for checking code coverage

## Tests

+ Resource Files - There are two sets of files. One in src/main/resources and other in src/test/resources. These can be used to test out the functionality with ease.
+  The src/test/java folder has Unit Tests and Integration Tests written. You can run them as JUnit Tests

## Instructions to Validate the application:

+ mvn clean install will download required artifacts and package the jar
+ Run MainApp class on IDE , uses Java 8
+ You can play with the inputs from files ContactSheetCSV1.txt and ContactSheetCSV2.txt both representing two address books.
+ The unit test and Integration tests are present in the src/test/java.
+ Log4j2.xml can be configured to set the level of the logger we would like to use.
+ mvn cobertura:cobertura can be run to check the line coverage and branch coverage.