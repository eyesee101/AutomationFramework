# Automation Framework Starter
### By James Snee
This Intellij project is designed to jump-start automation framework development. It contains some sample TestData and a DataProvider.
It also contains some sample properties in a config.properties file as well as loading properties and a method to set individual 
properties.

# Maven Repositories
This project has used the following dependencies:

- TestNG
- RestAssured
- slf4j
- XML APIs
- Javax XML Parsers

# Execution
To run, simply right-click on `SimpleTest.helloTest` from the `src/test/java/` directory within Intellij and click Run.
You can also create a Run Configuration to execute easily using different parameters.

# Troubleshooting
The test should load the xml files stored in `src/main/resources/Data/` directory and print them to the console. If the test does not run correctly, please check the dependencies in the `pom.xml` file.

# Todo

- Jenkins Integration
- API calls using RestAssured
- XML Parsing
- Set up running from the command line
- Reporting (either Allure or Extent reports)