From openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8089
ADD target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-2.0.war app.war
ENTRYPOINT ["java","-jar","/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-2.0.war"]
