# Stage 1: Build the JAR using Maven
FROM maven:3.9.6-eclipse-temurin-21 AS builder

WORKDIR /app

# Copy all source code
COPY . .

# Package the app (skip tests for faster build)
RUN mvn clean package -DskipTests

# Stage 2: Run the app using JDK only
FROM openjdk:21-jdk-slim

WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/TaskManagementApp-0.0.1-SNAPSHOT.jar app.jar

# Run the jar
ENTRYPOINT ["java", "-jar", "app.jar"]
