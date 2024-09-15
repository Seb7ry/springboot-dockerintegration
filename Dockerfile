# Sets the base image to OpenJDK 17, a lightweight and optimized version of the Java Development Kit (JDK).
FROM openjdk:17-jdk-alpine

# Copies the generated .jar file from the local file system (in the path "target/springboot-docker.jar")
# to the working directory "/app" inside the container. This file contains the packaged application.
COPY target/devops-0.0.1-SNAPSHOT.jar springboot-docker.jar

# Defines the entry point for the container, which is the command that will be executed when the container starts.
# In this case, the container will run the command to start a Java application that runs the specified .jar file.
ENTRYPOINT ["java", "-jar", "springboot-docker.jar"]


