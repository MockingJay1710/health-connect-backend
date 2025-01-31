FROM openjdk:17-jdk-alpine
LABEL authors="salah"
WORKDIR /app

COPY target/health-connect.jar app.jar

COPY src/main/resources/application.properties /app/config/application.properties

EXPOSE 8080

ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_SHOW_SQL=true
ENV SPRING_DATASOURCE_URL=jdbc:mysql://host.docker.internal:3306/projetintegre
ENV SPRING_DATASOURCE_USERNAME=root
ENV SPRING_DATASOURCE_PASSWORD=salah
ENV SPRING_JOOQ_SQL_DIALECT=SQLDialect
ENV SPRING_DATASOURCE_DRIVER_CLASS_NAME=com.mysql.cj.jdbc.Driver
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENTRYPOINT ["java", "-jar", "app.jar", "--spring.config.location=/app/config/application.properties"]