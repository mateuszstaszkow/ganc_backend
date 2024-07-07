# Stage 1: Build the application
FROM gradle:7.4.2-jdk11 as builder

WORKDIR /home/gradle/project

# Copy the build files
COPY --chown=gradle:gradle . /home/gradle/project

# Build the application
RUN gradle build --no-daemon

# Stage 2: Create the runtime image
FROM openjdk:22-jdk-slim

WORKDIR /app

# Copy the jar file from the build stage
COPY --from=builder /home/gradle/project/build/libs/*.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
