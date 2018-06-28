#!/bin/bash

./wait.sh mysql:3306 -- echo "mysql is up"
if [$? -eq "0"]
then
   java -jar /target/chat-app-demo-0.0.1-SNAPSHOT.jar
fi
