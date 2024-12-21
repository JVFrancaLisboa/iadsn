# Fase 1: Build
FROM maven:3.8.8-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean install -DskipTests

#Fase 2: Runtime
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/iadsn-0.0.1-SNAPSHOT.jar ./iadsn.jar
EXPOSE 8080
CMD ["java", "-jar", "iadsn.jar"]