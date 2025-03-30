pipeline {
  agent any

  stages {
    stage('Checkout GitHub Repository') {
      steps {
        checkout scm
      }
    }
	
	stage('Build Spring Boot JAR') {
	  steps {
		script {
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
            sh 'docker dhwanii08/whong4_student-survey-form:$BUILD_NUMBER'
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