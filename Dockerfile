FROM maven:3.9.0-eclipse-temurin-11

WORKDIR /app

COPY .. .

ARG DEFAULT_PORT=8080

EXPOSE $DEFAULT_PORT

ENTRYPOINT ["mvn", "spring-boot:run"]
