Installation:

  Clone this project or extract it and set up in local computer.

  If you do not have a linux/unix environment please install Postman at: https://www.postman.com/

  Alternatively, if you have a linux/unix environment you can use your package manager to 
  install maven, for me it is: apt-get install maven
  
  
  

Running the Project:

  Build the project in your IDE, and after that completes, 
  run the FetchRewardsAssessmentApplication.java
  file in package com.example.fetchrewardsassessment in your IDE

  If you have a linux/unix environment, you can run the project using: mvn spring-boot:run

  If the project successfully ran, it should be listening on port 8084
  
  
  

POST Requests:

  To send data to the application using Postman:

  1. run Postman application 
  2. change the Request type to POST
  3. Under the Body tab, change the data type to 'raw'
  4. Change the Text type to JSON in the drop-down list

  Inside the body of the request, format the JSON as such:

  {
  "version1":"version_number1",
  "version2":"version_number2"
  }

  where version_number1 and version_number2 consist of numbers between 0-9 and '.' (periods) only,
  any other characters given will respond with a badly formatted message:
  "Version1 or Version2 or both are badly formatted!".

  if you have a linux/unix environment you may also send a POST request from the terminal as well via:

  curl -d '{"version1":"version_number1", "version2":"version_number2"}' -H "Content-Type: application/json" -X POST http://localhost:8084/versions

  After a successful run the response body should look like one of the following:

  version1 is after version2

  version1 is before version2

  version1 is equal to version2

  Version1 or Version2 or both are badly formatted!
  
  
  

Examples:

  {
  "version1":"1",
  "version2":"1"
  }

  response: 1 is equal to 1

  {
  "version1":"2.0.1",
  "version2":"3.0.3"
  }

  response: 2.0.1 is before 3.0.3

  {
  "version1":"4.7.5",
  "version2":"4.7"
  }

  response: 4.7.5 is after 4.7

  {
  "version1":"1d#^%#/.",
  "version2":"4.6)"
  }

  response: Version1 or Version2 or both are badly formatted!





