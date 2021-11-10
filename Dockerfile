From openjdk:8-jdk-alpine
EXPOSE 8084
ADD target/timesheet-1-2.0.war timesheet-1-2.0.war
ENTRYPOINT ["java","-war","/timesheet-1-2.0.wa"]

