FROM amazoncorretto:21-alpine-jdk
WORKDIR /app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./

RUN ./mvnw dependency:resolve

COPY app ./src

CMD ["./mvnw", "spring-boot:run"]