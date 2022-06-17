FROM openjdk:12-jdk-alpine
VOLUME /tmp
EXPOSE 8082
ADD build/libs/ChatApp-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# build the application jar file:  gradle clean build jar
# run the application jar file:    java -jar build\libs\ChatApp-1.0-SNAPSHOT.jar

# pull mysql docker image:         docker pull mysql
# run msql docker container:       docker run -p 3307:3306 --name mysqldb -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=chatappdb mysql

# create docker image:             docker build -t chatappbackend .
# run docker image:                docker run -p 8888:8888 chatappbackend