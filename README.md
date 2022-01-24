# log-service
a simple logging microservice.
### Usage
the log-service application allows all basic create and get operations for log entities.
### Requirements
Apache Maven 3.8 or higher 

Docker 18.* or higher (was build with version 18.09.1)

docker-compose version 1.24 or higher (should work properly on all versions 1.* but was tested on v.1.24)

### Architecture
(DB-Postregs Log-Store ) <-*JDBC*-> [Log-Service] <-*REST*-> [Log-Proxy]

Contains three docker containers, one postregs db, one REST API that communicates with the configured DB, and a proxy REST API.

### Setup
Change the IP-addresses inside install/.env accordingly. 

### Install Guide *Quick*
Running on a \*NIX system execute the *install.sh* shell script inside the project root folder
```shell
sh install.sh
```

### Install Guide
Running on a \*NIX system run the following commands in the shell:

```shell
mvn -f LogApi/ clean install
cp LogApi/target/LogApi.jar LogApi/install/
```

```shell
mvn -f LogProxy/ clean install
cp LogProxy/target/LogProxy.jar LogProxy/install/
```

finally start all containers
```shell
cd install
docker-compose up --build
```


