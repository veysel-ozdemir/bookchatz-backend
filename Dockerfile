# Use an official Eclipse Temurin runtime as a parent image
FROM eclipse-temurin:22

# Set the working directory inside the container
WORKDIR /app

# Copy the executable jar file into the container
COPY target/blog-0.0.1.jar /app/app.jar

# Expose the port your application will run on
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
