FROM openjdk:11.0.9.1-jre
ADD /target/app.jar /app/application.jar
ENTRYPOINT ["java", "-jar", "/app/application.jar"]