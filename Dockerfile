FROM eclipse-temurin:17
WORKDIR /app
COPY . .
RUN chmod +x mvnw
CMD ["./mvnw", "spring-boot:run"]
