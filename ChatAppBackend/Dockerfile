FROM openjdk:12-jdk-alpine
VOLUME /tmp
EXPOSE 8082
ADD build/libs/ChatApp-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

# 1. pull mysql docker image:               docker pull mysql
# 2. run msql docker container:             docker run -p 3306:3306 --name mysqldb -e MYSQL_ALLOW_EMPTY_PASSWORD=true -e MYSQL_DATABASE=chatapp mysql
# 3. build the application jar file:        gradle clean build jar
# 4. create chatappbackend docker image:    docker build -t chatappbackend .
# 5. create spring-net network:             docker network create spring-net
# 6. run chatappbackend:                    docker run -p 9090:8080 --name chatappbackend --net spring-net -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD= -e MYSQL_PORT=3306 chatappbackend