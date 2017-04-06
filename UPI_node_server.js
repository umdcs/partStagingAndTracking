//Basic Node Server for UPI Project

//Variables:

var jobsArray = [];

var jobHours = [];
//End Variables

var express = require('express');

var bodyParser = require('body-parser');

var app = express();

app.set("port", 8090);

app.use(bodyParser.urlencoded({ // support encoded bodies
  extended: true
}));

 app.use(bodyParser.json()); // support json encoded bodies

 app.get('/', function(request, response) {
   response.writeHead(200, {'Content-Type': 'text/html'});

   response.write('<!DOCTYPE html><head><title>Basic Manager Dashboard</title></head><body>');
   response.write('<H1>Manager Dashboard</H1>');
   response.write('')
   response.end();

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

 app.post('/addJob', function(request, response) {
   if(!request.body) return res.sendStatus(400);

   var aJob = request.body.job;
   jobsArray.push(aJob);

   console.log('Received a post request for adding a job!');
   response.end();
 });

//To be manager only  
app.get('/getJobHours', function(request, response) {
  response.send(jobHours[0]); //0 is placeholder for jobID;
  console.log('Recieved a get request for man hours!');
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
