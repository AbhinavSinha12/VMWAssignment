#!/bin/sh

mvn clean install -DskipTests=true 

docker build . --tag vmw:1.0.0
rm -rf target/vmw.tar.gz
docker save vmw:1.0.0 | gzip > target/vmw.tar.gz
