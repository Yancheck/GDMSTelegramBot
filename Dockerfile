FROM eclipse-temurin:21-jdk-jammy AS build
ENV APP_HOME=/app
WORKDIR $APP_HOME
COPY . .

RUN chmod +x gradlew
RUN ./gradlew build -x test --no-daemon

FROM eclipse-temurin:21-jre-jammy
ENV APP_HOME=/app
WORKDIR $APP_HOME
COPY --from=build $APP_HOME/build/libs/*-all.jar app.jar || \
COPY --from=build $APP_HOME/build/libs/*SNAPSHOT.jar app.jar || \
COPY --from=build $APP_HOME/build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar"]
