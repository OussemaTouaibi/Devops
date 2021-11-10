From openjdk:8-jdk-alpine
COPY target/timesheet-1-2.0.war app.war
ENTRYPOINT ["java","-war","app.war"]
