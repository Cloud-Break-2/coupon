FROM --platform=$BUILDPLATFORM gradle:8-jdk17 AS builder
WORKDIR /home/gradle
COPY . /home/gradle
RUN ./gradlew build -x test

FROM eclipse-temurin:17-jre
WORKDIR /app
RUN apt-get update && apt-get install -y mysql-client redis-tools
COPY --from=builder /home/gradle/coupon-api/build/libs/coupon-api.jar /app/coupon-api.jar
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=docker", "/app/coupon-api.jar"]
EXPOSE 8080
