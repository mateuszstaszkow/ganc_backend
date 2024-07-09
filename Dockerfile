# Use an official OpenJDK runtime as a parent image
FROM openjdk:22-jdk-slim

# Set the working directory
WORKDIR /home/app

# Copy the current directory contents into the container at /app
COPY /home/app/build/libs/*.jar /usr/local/lib/app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/usr/local/lib/app.jar"]
