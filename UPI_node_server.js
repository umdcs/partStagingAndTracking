//Basic Node Server for UPI Project

var express = require('express');

var app = express();

app.set("port", 8080);

app.listen(app.get("port"), function () {
	console.log('UPI Node Server: Node app listening on port: ', app.get("port"));
    });
