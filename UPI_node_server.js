//Basic Node Server for UPI Project

//Variables:

var jobsArray = [];

var jobsInfoArray = {
    'lastUpdated' : 0,
    'jobArray' : []
}

var express = require('express');

var bodyParser = require('body-parser');

var app = express();

var path = require("path");

app.set("port", 8090);

app.use(bodyParser.urlencoded({ // support encoded bodies
    extended: true
}));

app.use(bodyParser.json()); // support json encoded bodies

app.get('/', function(request, response) {
    response.sendFile(path.join(__dirname + '/managerDashboard.html'));
    // response.writeHead(200, {'Content-Type': 'text/html'});
    //
    // response.write('<!DOCTYPE html><head><title>Dashboard</title></head><body>');
    // response.write('<H1><center>Manager Dashboard</center></H1>');
    // response.write('Current Jobs:');
    // response.write('<script language="javascript" type="text/javascript">');
    // response.write('for(var i = 0; i < jobsInfoArray.length; i++) { document.write("Job " +i+ ": name: " +jobsInfoArray.jobArray[i].name+ "<br />");}');
    // response.write('</script>');
    // response.write('</body><html>');
    // //response.write('JSON Data:');
    //
    // /* You could output any JavaScript data here... */
    // //response.write(JSON.stringify(jobsArray, null, 4));
    // //response.write('</body></html>');
    //
    console.log('Received dashboard request!');
});

app.get('/getAllJobs', function(request, response) {
    response.send(jobsArray);
    console.log('Received a get request for all jobs!');
    response.end();
});

app.get('/getJobByID', function(request, response) {
    //An ID should be sent up with request, so a specific job can be grabbed
    //Then send back the job corresponding to the ID
    response.send(jobsArray[0]); //0 for now, will search for job ID later
    console.log('Received a get request for a job by ID!');
    response.end();
});

/* getJobInfo will be used to send an array with Job ID's and
   the Job names. This will be used to display the current jobs
   that are on the server. Then as the user wants to update or view
   specific jobs, will the job be requested from the server */

/*
app.get('/getJobInfo', function(request, response) {
    var jobsInfoArray = [];
    var jobInfo;

    for(var i = 0; i < jobsArray.length; ++i) {
	jobInfo = { "jobID" : "", "jobName" : "" };
	jobsInfoArray.push[jobInfo];
    }

    response.send(jobsInfoArray);
    console.log('Received a get request for the names of jobs!');
    response.end();
});
*/

app.post('/addJob', function(request, response) {
    if(!request.body) return res.sendStatus(400);

    var aJob = request.body.Job;
    jobsArray.push(aJob);

    console.log('Received a post request for adding a job!');
    response.end();
});


/* updateJob will be sent a Job to update, and an index
   where this job is located (to be updated). From this,
   the job can be updated easily without touching other data */

app.post('/importantInfo', function(request,response) {
    if(!request.body) return response.sendStatus(400);

    //var aJob = request.body.Job;

    var info = {"name" : request.body.name, "ID" : request.body.ID}
    jobsInfoArray.jobArray.push(info);

    //response.write("Success");
    console.log('Pushed Name and ID onto jobsInfoArray');
    response.end();
});

app.get('/getImportantInfo', function(request,response) {
    /*
    response.writeHead(200, {'Content-Type': 'text/html'});

    response.write('<!DOCTYPE html><head><title>Job Information</title></head><body>');
    response.write('<H1>Names and Numbers</H1>');
    response.write('JSON Data:');

    /* You could output any JavaScript data here... *
    response.write(JSON.stringify(jobsInfoArray));
    response.write('</body></html>'); */

    //response.send(jobsInfoArray);
    //response.write(jobsInfoArray);

    console.log('Received request to get important job information');
    response.json(jobsInfoArray);
    //response.end();
});

app.post('/updateJob', function(request, response) {
    if(!request.body) return res.sendStatus(400);

    var update = request.body.Job;
    var indexToUpdate = request.body.ID;

    jobsArray[indexToUpdate] = update;

    console.log('Received a post request for updating a job!');
    response.end();
});

app.use(function(req, res, next) {
    res.status(404).send("Sorry can't find that!");
});

app.use(function(err, req, res, next) {
    console.error(err.stack);
    res.status(500).send("Something broke!");
});

app.listen(app.get("port"), function () {
    console.log('UPI Node Server: Node app listening on port: ', app.get("port"));
});
