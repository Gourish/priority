# priority
Sample spring boot application to store user priority areas and ratings.

This is a spring boot project using maven. 

## Local setup:
Make sure postgreSQL is running in local.
Edit application.properties to have proper credentials.

## Commands for running the application:
$mvn clean install
 got to target folder 
 
$java -jar priority-0.0.1-SNAPSHOT.jar

## Assumptions:
Application assumes that user and areas already exists in the user and area table respectively. New user or new area should  be added in the database directly . 
If the REST API request has new user or new area then application it throws error with status code 500.

## REST endpoints
REST API to get all the areas in the database
GET  /priority/allAreas 

sample response:
[
    {
        "areaId": 1,
        "areaName": "Connection"
    },
    {
        "areaId": 2,
        "areaName": "Relationships"
    },
    {
        "areaId": 3,
        "areaName": "Career"
    }
]

REST API to add user priorities to the database

POST /priority/user/{userid}

sample request body :

[
{
	"areaName" : "Connection",
	"rating" : 4
},
{
	"areaName" : "Wealth",
	"rating" : 2
},
{
	"areaName" : "Career",
	"rating" : 5
},
{
	"areaName" : "Relationships",
	"rating" : 5
}
]

sample response :
Status code 200

