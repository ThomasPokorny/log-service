# log-service
a simple logging microservice.
#### Usage
the log-service application allows all basic create and get operations for log entities.
#### Requirements
Apache Maven 3.8 or higher 
Docker 18.* or higher (was build with version 18.09.1)
docker-compose version 1.24 or higher (should work properly on all versions 1.* but was tested on v.1.24)

#### Architecture
(DB-Postregs Log-Store ) <--*JDBC*--> [Log-Service] <--*REST*--> [Log-Proxy]
