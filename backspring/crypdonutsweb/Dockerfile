# Set the base image
FROM openjdk:17-jdk-alpine

# Set the jar file location as a variable
ARG JAR_FILE=build/libs/*.jar

# set environment variable
ENV CUSTOM_NAME=default

# copy the jar file inside the container
COPY ${JAR_FILE} test-app.jar

# Expose the port that the Spring Boot app will listen on (change the port if necessary)
EXPOSE 8080

# run command
CMD ["java", "-Dtest.customName=${CUSTOM_NAME}", "-jar", "test-app.jar"]

