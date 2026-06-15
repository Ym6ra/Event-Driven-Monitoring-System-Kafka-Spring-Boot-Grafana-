FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /demo
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /demo
COPY --from=build /demo/target/*.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]