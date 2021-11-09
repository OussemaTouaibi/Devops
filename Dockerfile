From openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8089
ADD target/timesheet-1-2.0.war app.war
ENTRYPOINT ["java","-war","/timesheet-1-2.0.war"]