#File: Dockerfile
#Description: This Dockerfile defines the multi-stage Docker build process for building and running the application.
#Author: Alexander D Spies
#Date: 9 March 2024
#
#This Dockerfile specifies the build and runtime stages using different Docker images.
#It first uses the official Gradle image with JDK 17 to build the application, then switches to the OpenJDK 17 image for the runtime.
#Usage:
#- Customize the Gradle version and JDK version as needed.
#- Run `docker build -t <image_name> .` to build the Docker image.
#- Run `docker run -p 8080:8080 <image_name>` to start the Docker container.
#
#For more information about Dockerfile syntax and best practices, refer to the official documentation:
#- Dockerfile reference: https://docs.docker.com/engine/reference/builder/
#

# Use the official Gradle image with JDK 17 for the build stage
FROM gradle:7.5.1-jdk17 as builder
WORKDIR /app
# Copy the source code into the container
COPY --chown=gradle:gradle . /app
# Build the application without starting the daemon and skip tests
RUN gradle clean build --no-daemon

# Use OpenJDK 17 for the runtime stage
FROM openjdk:17-slim as runtime
WORKDIR /app
# Copy the JAR file from the build stage
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
