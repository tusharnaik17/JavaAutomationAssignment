# Automation Automation

## Application Overview
[Cueback](https://www.cueback.com/) provides a deeper level of engagement by leveraging the science of reminiscing to create emotional connections with your alumni.

## Automation Overview
Cueback Web Automation Framework utilizes open source [Selenium](http://seleniumhq.org/) tool to automate Cueback Application test cases on popular browsers.

## Supported Platforms
- **Chrome** Latest Version
- **IE:** Latest Version
- **Firefox** Latest Version


## Tools
- **Selenium:** for browser interaction 
- **Maven:** for Java project management  
- **TestNG:** for Java Testing framework 
- **Log4j:** to log test execution activities
- **Allure Report:** to report test execution results
- **Git Repository:** to store code
- **Seleniun Grid:** for parallel test execution
- **Jenkins:** for CI/CD.

## Integration
- **yopmail:** to exchange information with user
---

## Project Setup
- **Automation Code** 
   GIT repository URL: https://github.com/tushar0556/CuebackAutomation
- **Pre-requisites**
   - Java SDK 1.8: JAVA_HOME and Java path is setup in system variables.
   - Maven v3.x.x: M2_HOME and MAVEN_HOME are setup in system variables.
   - Eclipse IDE is installed on machine and it should have Git, Maven, and TestNG plugins setup.
   - Java and Maven installed path should be setup in Eclipse IDE.
- **Steps**
   - Launch Eclipse and open its Import window from File menu.
   - Expand Git folder and select "Project From Git" option.
   - Click on Next button.
   - Select "Clone URI" as repository source and click on Next button.
   - Enter Git repository URI - "https://github.com/tushar0556/CuebackAutomation.git"
   - Enter credentials and click on Next button.
   - Select "master" branch and click on Next button.
   - Code should be started downlaoded in git folder inside the system user.
   - Click on Finish button after code is downloaded.
   - Reopen Eclipse Import window and expand Maven folder.
   - Select "Existing Maven Projects" option and click on Next button.
   - Click on Browser button to set root directory - System user -> git - > ESAutomation -> ES.
   - Select pom.xml file and click on Next button.
   - Click on finish button.
   - Cueback maven project should be displayed in Eclipse.
- **Execution**     
   - Right Mouse Click on Cueback folder and select Run As-> Maven Build..
   - Enter "clean test site exec:java" in Goals text box (without "").
   - Select JRE tab and add "-DEnv=qa -DBrowser=chrome -DTestSuite=smoke -Dexec.mainClass=com.cueback.setup.DriverScript -Dexec.cleanupDaemonThreads=false -javaagent:C:\Users\<system_user>\.m2\repository\org\aspectj\aspectjweaver\1.8.13\aspectjweaver-1.8.13.jar" to VM args ((without "").
   - Click on Run.
   - Maven will start downloading project dependencies
   - wait for some time, browser will launch and execution will starts.

## Execution
### Local 
- **Chrome:** -DEnv=qa -DBrowser=chrome -DTestSuite=smoke -Dexec.mainClass=com.cueback.setup.DriverScript
- **FireFox:** -DEnv=qa -DBrowser=Firefox -DTestSuite=smoke -Dexec.mainClass=com.cueback.setup.DriverScript
- **IE:** -DEnv=qa -DBrowser=IE -DTestSuite=smoke -Dexec.mainClass=com.cueback.setup.DriverScript

### Jenkins
In progress 


## Change Log
- Version 1.0.0 - [Change Log](CHANGELOG.md)

## Contributors
- 


## License & copyright
Copyright � 2018 Cueback.
All rights reserved.
This is the confidential and proprietary information of 
Cueback. ("Confidential Information").  You shall not
disclose such Confidential Information and shall use it only in
accordance with the terms of the license agreement you entered into
with Cueback.

