FROM eclipse-temurin:21-jdk-jammy AS build
ENV APP_HOME=/app
WORKDIR $APP_HOME
COPY . .
RUN chmod +x gradlew
RUN ./gradlew build -x test --no-daemon

FROM eclipse-temurin:21-jre-jammy
ENV APP_HOME=/app
WORKDIR $APP_HOME

COPY --from=build $APP_HOME/build/libs/ /app/libs/

CMD ["sh", "-c", "java -jar /app/libs/*.jar"]
