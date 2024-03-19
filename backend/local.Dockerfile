FROM maven:3.8.3-openjdk-17-slim

WORKDIR /app

COPY . .

EXPOSE 8080

CMD ["mvn", "spring-boot:run"]