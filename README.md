# United Piping Node Server 
Node.js server running on http://akka.d.umn.edu:3317 (131.212.41.37:3317)

This server stores all job data for the United Piping Android Application.

This server can be used in conjunction with the android application available at: 
https://github.umn.edu.umdcs4531/unitedpiping_android

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
