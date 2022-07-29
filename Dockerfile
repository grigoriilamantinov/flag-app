FROM adoptopenjdk/openjdk11:alpine-jre
ARG JAR_FILE=/build/libs/*.jar
COPY ${JAR_FILE} flag-app-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","flag-app-0.0.1-SNAPSHOT.jar"]