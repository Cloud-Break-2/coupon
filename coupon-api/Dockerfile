FROM --platform=$BUILDPLATFORM gradle:8-jdk17 AS builder
WORKDIR /home/gradle
COPY . /home/gradle
RUN ./gradlew build -x test

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=builder ./coupon-api/build/libs/coupon-api.jar /app/coupon-api.jar
ENTRYPOINT ["java", "-jar", "/app/coupon-api.jar"]
EXPOSE 8080
