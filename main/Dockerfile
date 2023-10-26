FROM maven:3.8.4-openjdk-17 AS java-build

WORKDIR /app

COPY main/ /app/

RUN mvn clean install

ENTRYPOINT ["java", "-jar", "target/main-0.0.1-SNAPSHOT.jar"]