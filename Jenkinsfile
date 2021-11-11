pipeline {
    agent any
    
	environment { 
        pom = readMavenPom file: 'pom.xml'
	DOCKER_IMAGE_VERSION = "${env.BUILD_NUMBER}"
       

    }
    tools {
        maven 'maven'
        jdk 'jdk'
        dockerTool 'docker'
		
    }

 
	

    stages {
	
        stage('Build') {

            steps {

                echo 'INSIDE Build Stage'

                bat "mvn clean package"
            }
        }

		
        stage('Sonar') {
 
            steps {

                echo 'INSIDE Sonar Stage'

              
                    bat "mvn sonar:sonar"
                
            }
        }
		 stage('Nexus') {
            steps {

                echo 'INSIDE Nexus'
                bat "mvn deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=$BUILD_NUMBER -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo  -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-0.0.1-SNAPSHOT.jar"
            }
        }
		stage ('Build Docker Image'){
		    steps {
			   echo 'Inside build Docker Image Stage'
			   
			   bat "mvn dockerfile:build -Ddockerfile.repository=timesheet-spring-boot-core-data-jpa-mvc-rest-1"
		}
    }
/*
		stage ('Push to registry'){
		    steps {
			   echo 'Inside Push to registry Stage'
			  
			       bat "docker login -u yassineali -p 7Octobre1998"
			       bat "docker tag timesheet-spring-boot-core-data-jpa-mvc-rest-1:latest yassineali/timesheet-spring-boot-core-data-jpa-mvc-rest-1:${DOCKER_IMAGE_VERSION}"
			       bat "docker push yassineali/timesheet-spring-boot-core-data-jpa-mvc-rest-1:${DOCKER_IMAGE_VERSION}"
				
				  
				   
				 }
			   }
		*/
		
}
}
