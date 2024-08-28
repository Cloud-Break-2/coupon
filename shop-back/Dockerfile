FROM --platform=$BUILDPLATFORM gradle:8-jdk17 AS build
WORKDIR /home/gradle
COPY . /home/gradle
RUN gradle build

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /home/gradle/build/libs/kakao-1.0.jar /app/kakao-1.0.jar
ENTRYPOINT ["java", "-jar", "/app/kakao-1.0.jar"]
EXPOSE 8082
