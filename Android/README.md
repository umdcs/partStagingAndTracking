# united_pipeline

This application tracks the seven stages of develop on each piece within a job for United Piping, Inc. The app has different functionality for clients and managers.

Android Studio version 2.3.1

The application is meant to be used in conjuction with a Node.js server that runs on akka.d.umn.edu:3317 (131.212.41.37:3317).

Testing
Alex's unit test:
-   Tests both the JobProgress and JobHours functions, along with a very basic test of ensuring that job creation takes place and amount of pieces is correct. 
-   To run this test, go to the 'java/test/ProgressAndHoursTest', right click on it and press run 'ProgressAndHoursTest'.

Katia's unit test:
-   Test the constructors of the Job and Piece classes. Checks that these constructors function and correctly initialize all values.
-   To run this test, go to the 'java/test/JobUnitTest', right click on it and press run 'JobUnitTest'.
