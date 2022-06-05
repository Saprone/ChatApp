FROM openjdk:12-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
#gradle clean build jar
#java -jar build\libs\ChatApp-1.0-SNAPSHOT.jar
#docker build -t chatapp .
#docker run -p 8888:8888 chatapp