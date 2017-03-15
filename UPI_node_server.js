//Basic Node Server for UPI Project

var express = require('express');

var bodyParser = require('body-parser');

var app = express();

app.set("port", 8080);

app.use(bodyParser.urlencoded({ // support encoded bodies
  extended: true
}));

 app.use(bodyParser.json()); // support json encoded bodies

 app.get('/', function(request, response) {
   response.writeHead(200, {'Content-Type': 'text/html'});

   response.write('<!DOCTYPE html><head><title>Basic Manager Dashboard</title></head><body>');
   response.write('<H1>Manager Dashboard</H1>');

   response.end();

   console.log('Received dashboard request!');
 });

 app.get('/getAllJobs', function(request, response) {
   console.log('Received a get request for all jobs!');
   response.end();
 });

 app.get('/getJobByID', function(request, response) {
   console.log('Received a get request for a job by ID!');
   response.end();
 });

 app.post('/addJob', function(request, response) {
   console.log('Received a post request for adding a job!');
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
