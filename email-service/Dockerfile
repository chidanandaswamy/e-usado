FROM openjdk:11-jre-slim
ADD ./target/email-service-0.0.1-SNAPSHOT.jar email-service-0.0.1-SNAPSHOT.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","email-service-0.0.1-SNAPSHOT.jar"]
