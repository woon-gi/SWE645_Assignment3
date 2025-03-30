pipeline {
  agent any
  environment {
	JAVA_HOME = "/usr/lib/jvm/java-21-openjdk-amd64"
    PATH = "$JAVA_HOME/bin:$PATH"
  }

  stages {
    stage('Checkout GitHub Repository') {
      steps {
        checkout scm
      }
    }
	
	stage('Build Spring Boot JAR') {
	  steps {
		script {
		  sh 'echo "Using JAVA_HOME: $JAVA_HOME"'
		  sh 'chmod +x gradlew'  // Fix permission issue
		  sh './gradlew clean build'  // Build the JAR using Gradle
		}
	  }
	}
    
    stage('Build Docker Image') {
      steps {
        script {
            sh 'echo $BUILD_NUMBER'
            withCredentials([usernamePassword(credentialsId: 'docker-hub', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
				sh 'echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin'
			}
            sh 'docker build -t dhwanii08/whong4_student-survey-form:$BUILD_NUMBER .'
        }
      }
    }
    
    stage('Push to Docker Hub') {
      steps {
        script {
            sh 'docker push dhwanii08/whong4_student-survey-form:$BUILD_NUMBER'
			
          }
        }
      }
    
    stage('Deploy to Rancher') {
      steps {
        script {
          sh 'kubectl set image deployment/swe-645-hw3-survey-form container-0=dhwanii08/whong4_student-survey-form:$BUILD_NUMBER'
        }
      }
    }
  }
}