# Distributed Part Staging and Tracking 

This application tracks the seven stages of develop on each piece within a job. The app has different functionality for clients and managers.

Android Studio version 2.3.1

The application is meant to be used in conjuction with a Node.js server that runs on a server machine.

Testing
Alex's unit test:
-   Tests both the JobProgress and JobHours functions, along with a very basic test of ensuring that job creation takes place and amount of pieces is correct. 
-   To run this test, go to the 'java/test/ProgressAndHoursTest', right click on it and press run 'ProgressAndHoursTest'.

Katia's unit test:
-   Test the constructors of the Job and Piece classes. Checks that these constructors function and correctly initialize all values.
-   To run this test, go to the 'java/test/JobUnitTest', right click on it and press run 'JobUnitTest'.

# Node Server 
Node.js server running on server machine needs to be specified.

This server stores all job data for the Android Application.

This server can be used in conjunction with the android application available in the associated Android directory.

Default page displays each jobs's name and id

/getAllJobs returns the total number of jobs currently stored on the server

/getImportantInfo dumps the json data for each job




Testing

Basic Test File: testServer.sh <br />
To Run: Type ./testServer.sh in a shell (works on akka/ukko) <br /> 
This test file runs shell scripts that issue curl requests <br />
Scripts will test and display:
1) Dashboard Requests
2) GET requests (/getAllJobs, /)
3) POST requests (/addJob, and later /updateJob)
