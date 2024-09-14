# Sets the base image to OpenJDK 17, a lightweight and optimized version of the Java Development Kit (JDK).
# "slim" refers to a reduced version of the image to minimize its size.
FROM openjdk:17-jdk-slim

# Defines the working directory inside the container. All subsequent commands will be executed within this directory.
# This creates a directory called "/app" inside the container to store the application files.
WORKDIR /app

# Copies the generated .jar file from the local file system (in the path "target/springboot-docker.jar")
# to the working directory "/app" inside the container. This file contains the packaged application.
COPY target/devops-0.0.1-SNAPSHOT.jar /app/springboot-docker.jar

# Exposes port 8080 so the container can accept external connections through this port.
# This is the default port where a Spring Boot application runs.
EXPOSE 8080

# Defines the entry point for the container, which is the command that will be executed when the container starts.
# In this case, the container will run the command to start a Java application that runs the specified .jar file.
ENTRYPOINT ["java", "-jar", "springboot-docker.jar"]
