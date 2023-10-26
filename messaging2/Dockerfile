FROM maven:3.8.4-openjdk-17 AS java-build

WORKDIR /app

COPY messaging2/ /app/

RUN mvn clean install

ENTRYPOINT ["java", "-jar", "target/messaging2-0.0.1-SNAPSHOT.jar"]