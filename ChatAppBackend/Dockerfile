FROM openjdk:12-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# build the application jar file:  gradle clean build jar
# run the application jar file:    java -jar build\libs\ChatApp-1.0-SNAPSHOT.jar
# create docker image:             docker build -t chatapp .
# run docker image:                run -p 8888:8888 chatapp: