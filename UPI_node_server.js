//Basic Node Server for UPI Project

//Variables:

var jobsArray = [];

var jobsInfoArray = {
    //'lastUpdated' : 0,
    //'host' : 'UPI',
    'jobArray' : []
}

var express = require('express');

var bodyParser = require('body-parser');

var app = express()

var path = require("path");

app.set("port", 3316);

app.use(bodyParser.urlencoded({ // support encoded bodies
    extended: true
}));

app.use(bodyParser.json()); // support json encoded bodies

app.get('/', function(request, response) {
    response.writeHead(200, {'Content-Type' : 'text/html'});
    response.write('<H1><center>Manager Dashboard</center></H1>');
    response.write('<body>Current Jobs: <br />');
    var i;
    for(i = 0; i < jobsInfoArray.jobArray.length; i++) {
      response.write('Job ' + i + ': <br/>Client: ' + jobsInfoArray.jobArray[i].name + ', Job ID: ' + jobsInfoArray.jobArray[i].ID + ' <br />');
    }
    response.write('</body></html>');
    response.end();

    console.log('Received dashboard request!');
});

app.get('/getAllJobs', function(request, response) {
    if(!request.body) return res.sendStatus(400);
    console.log('Received a get request for all jobs!');
    response.send(jobsArray.length.toString());
    response.end();
});

/* getJobByID should take in one paramater, the ID, and search through the jobsInfoArray
   to find find the array element that we wish to find, from there it should take that index
   and grab the job (the same index) from the jobsArray. That data should then be written as
   a JSON string and sent back to the application. */
app.get('/getJobByID/:idNumber', function(request, response) {
    //An ID should be sent up with request, so a specific job can be grabbed
    //Then send back the job corresponding to the ID
    /*
        for(int i=0; i<jobsInfoArray.length(); i++) {
        if(jobsInfoArray.getID(i) == (Parameter that comes in)) {
        response.write(jobsArray[i];
        OR
        response.send(jobsArray[i];
        console.log('Found job')
        }
        }
        response.send('Job not found');
        response.end();
    */
    if(!request.body) return res.sendStatus(400);
    var id = request.params.idNumber;
    response.send(jobsArray[id]);
    console.log('Received a get request for a job by ID!');
    response.end();
});

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

    //var info = {"name" : request.body.name, "ID" : request.body.ID}
    var info = {"name" : request.body.name, "ID" : request.body.ID};
    jobsInfoArray.jobArray.push(info);
    //lastUpdated++;

    //response.write("Success");
    console.log('Pushed Name and ID onto jobsInfoArray');
    response.end();
});

app.get('/getImportantInfo', function(request,response) {

    console.log('Received request to get important job information');
    response.json(jobsInfoArray);
    //response.send(jobsInfoArray);
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
