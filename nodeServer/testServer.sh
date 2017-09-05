#!/bin/bash

printf "==================================\n"
printf "Testing REST API of Node Server\n"
printf "==================================\n"

printf "First Test: dashboard request:\nRaw HTML Data:\n"
curl --header "Content-type: application/json" --request GET http://131.212.41.37:8090/
printf "\n==================================\n"

printf "Second Test: sending {\"Job\": \"testData\"} to server:\n"
curl --header "Content-type: application/json" --request POST --data '{"Job": "testData"}' http://131.212.41.37:8090/addJob
printf "Done!\n"
printf "==================================\n"

printf "Third Test: dashboard request to view sent data (note: there may be data from other tests)\n"
printf "Raw HTML Data:\n"
curl --header "Content-type: application/json" --request GET http://131.212.41.37:8090/
printf "\n==================================\n"

printf "Fourth Test: get request for all jobs on the server:\nJSON Array:\n"
curl --header "Content-type: application/json" --request GET http://131.212.41.37:8090/getAllJobs
printf "\n==================================\n"

#printf "Fifth Test: post request to update job on server:\n"
#curl --header "Content-type: application.json" --request POST --data '{"Job": "updatedJob", "ID": "0"}' http://131.212.41.37:8090/updateJob
#printf "Done!\n"
#printf "Request all jobs to view index 0 (jobID 0) is updated:\nJSON Array:\n"
#curl --header "Content-type: application/json" --request GET http://131.212.41.37:8090/getAllJobs
#printf "\n==================================\n"

printf "End of server test\n"
printf "==================================\n"
