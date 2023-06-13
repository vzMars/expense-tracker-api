FROM maven:3.9.2-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk
COPY --from=build /target/expense-tracker-0.0.1-SNAPSHOT.jar expense-tracker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","expense-tracker.jar"]