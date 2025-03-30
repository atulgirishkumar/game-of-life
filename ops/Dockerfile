FROM amazoncorretto:21-alpine AS builder

RUN apk add --no-cache maven

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean install

FROM amazoncorretto:21-alpine

WORKDIR /app
COPY --from=builder /app/target/*-fat.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
