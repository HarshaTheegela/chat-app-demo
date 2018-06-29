#!/bin/bash
set -x
./wait.sh mysql:3306 -- java -jar target/chat-app-demo-0.0.1-SNAPSHOT.jar
