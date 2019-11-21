@echo off
call mvn clean package
call docker build -t com.filix/otc .
call docker rm -f otc
call docker run -d -p 9080:9080 -p 9443:9443 --name otc com.filix/otc