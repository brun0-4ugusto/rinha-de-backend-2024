FROM amazoncorretto:21-alpine-jdk
WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "-Xms120m","-Xmx120m","-XX:+UseStringDeduplication","-XX:+UseZGC","-XX:+ZGenerational", "app.jar"]