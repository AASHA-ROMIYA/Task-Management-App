# Use OpenJDK 21 base image
FROM openjdk:21-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the jar file from target directory (from local to container)
COPY target/TaskManagementApp-0.0.1-SNAPSHOT.jar app.jar

# Run the jar file when container starts
ENTRYPOINT ["java", "-jar", "app.jar"]

