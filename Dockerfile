FROM maven:3.6.0-jdk-11-slim
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY src ./src

CMD ["mvn", "spring-boot:run"]