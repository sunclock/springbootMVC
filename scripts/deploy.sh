#!/bin/bash

REPOSITORY=/home/ec2-user/app/step2
PROJECT_NAME=springbootMVC

echo "> Copy Build Files"
cp $REPOSITORY/zip/*.jar $REPOSITORY/

echo "> Check PID of Currently Working Application"

CURRENT_PID=$(pgrep -fl springbootMVC | grep jar | awk '{print $1}')

echo "PID of Currently Working Application: $CURRENT_PID"

if [ -z "$CURRENT_PID" ]; then
  echo "No Currently Working Application, No Application Terminated."
else
  echo "> kill -15 $CURRENT_PID"
  kill -15 "$CURRENT_PID"
  sleep 5
fi

echo "> Deploy New Application"

JAR_NAME=$(ls -tr $REPOSITORY/*.jar | tail -n 1)

echo "> JAR Name: $JAR_NAME"

echo "> Add Authority to Execute to $JAR_NAME"

chmod +x "$JAR_NAME"

echo "> Execute $JAR_NAME"

nohup java -jar \
  -Dspring.config.location=classpath:/application.properties,classpath:/application-real.properties,/home/ec2-user/app/application-oauth.properties,/home/ec2-user/app/application-real-db.properties \
  -Dspring.profiles.active=real \
  "$JAR_NAME" > $REPOSITORY/nohup.out 2>&1 &