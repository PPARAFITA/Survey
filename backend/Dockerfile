FROM adoptopenjdk/openjdk17:alpine-jre

WORKDIR /app

COPY target/thermometer-survey.jar /app/thermometer-survey.jar

RUN chown -R spring:spring /app

USER spring:spring

EXPOSE 8080

CMD ["java", "-jar", "thermometer-survey.jar"]