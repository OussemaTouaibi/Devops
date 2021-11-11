pipeline {
    agent any
    
	environment { 
        pom = readMavenPom file: 'pom.xml'
        ARTIFACTID=pom.getArtifactId()

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

                withSonarQubeEnv('SonarQube') {
                    bat "mvn -Dsonar.sources=src/main sonar:sonar"
                }
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
			   
			   bat "mvn dockerfile:build -Ddockerfile.repository=${ARTIFACTID}"
		}
    }
		
		
}
}
