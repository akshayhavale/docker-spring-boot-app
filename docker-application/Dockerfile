FROM maven:3-alpine AS build-project
ADD . ./docker-application
WORKDIR /docker-application
RUN mvn clean install

FROM openjdk:8-jre-alpine
EXPOSE 3212
WORKDIR /app
COPY --from=build-project ./docker-application/target/docker-application-0.0.1-SNAPSHOT.jar ./docker-application-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "docker-application-0.0.1-SNAPSHOT.jar"]

