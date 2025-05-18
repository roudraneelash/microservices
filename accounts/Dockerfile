#start with a base image containing Java runtime jre:17
FROM openjdk:17-jdk-slim

#infromation who maintans the image
LABEL maintainer="devuseash@gmail.com"

#Add the application jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#Execute the application
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]