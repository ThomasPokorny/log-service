#!/bin/bash
mvn -f LogApi/ clean install
cp LogApi/target/LogApi.jar LogApi/install/
#
mvn -f LogProxy/ clean install
cp LogProxy/target/LogProxy.jar LogProxy/install/
# 
cd install/
docker-compose up --build
