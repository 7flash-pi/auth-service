# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /
# Copy the JAR file into the container
COPY /target/auth-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE  8080
# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]