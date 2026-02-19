# === Stage 1: Build the application ===
# Use a JDK 21 image with Maven for compilation
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY . .
# Use -DskipTests or specific profiles as needed for your CI/CD
RUN mvn clean package -DskipTests


# === Stage 2: Run the application ===
# Use a minimal JRE 21 image for the final runtime
# Alpine Linux variant is very small, aiding security and efficiency
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Security best practice: Run as a non-root user
# RUN addgroup --system spring && adduser --system spring --group spring
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Expose the application port
EXPOSE 8090

# Copy the packaged JAR file from the 'build' stage
# Adjust 'target/*.jar' to match your build tool's output path if necessary
COPY --from=build /app/target/*.jar app.jar

# Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]