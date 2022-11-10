FROM openjdk:11
ADD target/weather-service.jar weather-service.jar
EXPOSE 8400
ENTRYPOINT [ "java", "-jar", "weather-service.jar" ]