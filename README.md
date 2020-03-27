# hub_logs
REST API created to centralize applications error records. The project is based on the concepts of Domain Driven Design and dependency injection, using tools such as Spring Boot, Spring Data, Spring Security with OAuth2, Lombok, Docker, Flyway and Swagger.

## Getting started

### Prerequisites
To execute the project, the following tools are required:

```
JDK 10: Required to execute the Java project
Maven 3.5.3: Required to build the Java project
IntelliJ IDEA: Required IDE to develop the project
PostgreSQL: Required to perform database queries
```


### Development
To start developing, clone the Github project in a directory of your choice.

```
https://github.com/BeatrizFreitas/hub-logs
```

## Usage Example
### Get list of Logs
#### Request
```
GET http://localhost:8080/logs/
```
#### Response
```
HTTP/1.1 200 OK
Date: Thu, 26 Mar 2020 18:26:30 GMT
Status: 200 OK
Content-Type: application/json
[]
```
### Create new Log
#### Request
```
POST http://localhost:8080/logs/
```
#### Response
```
HTTP/1.1 201 Created
Date: Thu, 26 Mar 2020 18:26:30 GMT
Status: 201 Created
Content-Type: application/json
{
  "id": "ea7394d3-1bf4-48e6-88c2-f7fec21f48c6",
  "errorLevel": "WARNING",
  "description": "Description of the error that occurred",
  "date": "2020-03-26",
  "origin": "168.100.35.29",
  "frequency": 3,
  "environment": "HOMOLOGATION"
}
```

## Authors
* [Beatriz Freitas](https://github.com/BeatrizFreitas/)
* [Louise Bahiense](https://github.com/louisebahiense/)
