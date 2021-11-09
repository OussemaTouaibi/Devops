From openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/timesheet-1-2.0.war 
ENTRYPOINT ["java","-jar","/timesheet-1-2.0.war"]
