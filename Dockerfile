# Use the official Gradle image with JDK 17 for the build stage
FROM gradle:7.5.1-jdk17 as builder
WORKDIR /app
# Copy the source code into the container
COPY --chown=gradle:gradle . /app
# Build the application without starting the daemon and skip tests
RUN gradle clean build --no-daemon -x test

# Use OpenJDK 17 for the runtime stage
FROM openjdk:17-slim as runtime
WORKDIR /app
# Copy the JAR file from the build stage
COPY --from=builder /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
