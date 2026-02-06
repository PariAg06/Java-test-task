#!/bin/bash
# Make sure the jar exists
if [ ! -f target/*.jar ]; then
    echo "Building the project..."
    ./mvnw clean package
fi

echo "Starting the Spring Boot app..."
java -jar target/*.jar
