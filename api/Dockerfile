FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src src
RUN mvn package -DskipTests

# Usa una imagen más ligera de OpenJDK para ejecutar la aplicación
#FROM openjdk:17-jdk-alpine
#si no funciona la imagen, ocupar la de arriba
FROM thingsboard/openjdk17:bookworm-slim
WORKDIR /app

COPY --from=build /app/target/api-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]