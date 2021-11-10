From openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/timesheet-1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]



