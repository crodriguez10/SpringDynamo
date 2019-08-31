FROM openjdk:8-jre-alpine
MAINTAINER cesar.rodriguez@pragma.com.co
ADD build/libs/demo-0.0.1-SNAPSHOT.jar dynamo.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "/dynamo.jar"]