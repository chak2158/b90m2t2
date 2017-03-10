/**
 * http://usejsdoc.org/
 */

var http = require("http");
var url = require("url");
var express = require("express");
var bodyParser = require("body-parser");
var crypto = require("crypto");
var CORS = require("cors");

var app = express();

app.use(CORS());
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended:true}));

app.get("/login/pass.do",function (request,response) {
	
	var password ="";
	password += request.query.pass;
	
	var sha1 = crypto.createHash("sha1");
	sha1.update(password);
	
	var output = sha1.digest("base64");
	
	console.log("원본 %s",password);
	console.log("해쉬 %s",output);
	
	response.writeHeader(200, {"Content-Type": "text/html; charset=UTF-8"});
	response.end(output);
	
	
});

http.createServer(app).listen(10001, function () {
    console.log('Server running at http://127.0.0.1:10001');
});
