From openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/timesheet-1-2.0.war app.jar
ENTRYPOINT ["java","-jar","/timesheet-1-2.0.war"]
