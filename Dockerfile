# FROM maven:3.9.9-eclipse-temurin as build

# USER 1000
# WORKDIR /workspace/app

# COPY pom.xml .
# RUN mvn -B -e -C -T 1C org.apache.maven.plugins:maven-dependency-plugin:3.6.0:go-offline

# COPY src src
# RUN mvn clean package -Dmaven.test.skip=true


# FROM eclipse-temurin:21-ubi9-minimal
FROM openjdk:17-alpine
VOLUME /tmp
USER 1000
# ARG DEPENDENCY=/workspace/app/target/dependency
# COPY /workspace/app/target/sample-spring-kotlin-microservice-1.5.2.jar app.jar
COPY /workspace/sample-spring-kotlin-microservice/target/sample-spring-kotlin-microservice-1.5.3.jar app.jar
ENTRYPOINT ["java","-jar", "app.jar"]
