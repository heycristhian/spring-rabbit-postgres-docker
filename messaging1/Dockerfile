FROM maven:3.8.4-openjdk-17 AS java-build

WORKDIR /app

COPY messaging1/ /app/

RUN mvn clean install

ENTRYPOINT ["java", "-jar", "target/messaging1-0.0.1-SNAPSHOT.jar"]