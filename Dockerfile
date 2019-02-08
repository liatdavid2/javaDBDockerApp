FROM openjdk:8
ADD target/db-service-0.0.1-SNAPSHOT.jar db-service-0.0.1-SNAPSHOT.jar
EXPOSE 7000
ENTRYPOINT ["java","-jar","docker-spring-boot.jar"]
