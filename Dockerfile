# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the executable jar file to the container
COPY target/mikoAssignment-0.0.1-SNAPSHOT.jar /app/mikoAssignment-0.0.1-SNAPSHOT.jar

# Install curl (if needed) and Redis
RUN apt-get update && \
    apt-get install -y curl redis-server

# Expose Redis port
EXPOSE 6379

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "mikoAssignment-0.0.1-SNAPSHOT.jar"]
