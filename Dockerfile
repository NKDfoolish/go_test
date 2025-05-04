# Stage 1: Build the application
FROM maven:3.8.6-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY diem_thi_thpt_2024.csv ./src/main/resources/
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/backend-0.0.1-SNAPSHOT.jar app.jar
COPY --from=builder /app/src/main/resources/diem_thi_thpt_2024.csv /app/src/main/resources/diem_thi_thpt_2024.csv
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]