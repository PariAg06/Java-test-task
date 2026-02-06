# Use a JDK image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy your build output (jar file) into the container
COPY target/*.jar app.jar

# Expose port (change if your app uses a different port)
EXPOSE 8080

# Run the jar
ENTRYPOINT ["java","-jar","app.jar"]
