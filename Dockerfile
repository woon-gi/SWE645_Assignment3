# Use the official OpenJDK 17 Alpine image
FROM openjdk:17-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot JAR file from the build directory
COPY build/libs/student-survey-form-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the application port
EXPOSE 8080

# Command to run your application
CMD ["java", "-jar", "/app/app.jar"]
