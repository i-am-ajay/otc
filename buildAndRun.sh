#!/bin/sh
mvn clean package && docker build -t com.filix/otc .
docker rm -f otc || true && docker run -d -p 9080:9080 -p 9443:9443 --name otc com.filix/otc