FROM maven:3.8.4-openjdk-17 AS java-build

WORKDIR /app

COPY main/target/main-0.0.1-SNAPSHOT.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]