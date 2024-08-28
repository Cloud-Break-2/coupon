FROM --platform=$BUILDPLATFORM gradle:8-jdk17 AS build
WORKDIR /home/gradle
COPY . /home/gradle
RUN gradle build

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build ./coupon-api/build/libs/coupon-api.jar /app/coupon-api.jar
ENTRYPOINT ["java", "-jar", "/app/coupon-api.jar"]
EXPOSE 8080

## 이렇게 안됨
