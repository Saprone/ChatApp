FROM openjdk:12-jdk-alpine
VOLUME /tmp
EXPOSE 8082
ADD build/libs/ChatApp-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]

#    % ChatApp-1.0-SNAPSHOT.jar %
# 1. build the application jar file:        gradle clean build jar

#    % mysql docker image %
# 1. mysql docker image:                    docker pull mysql

#    % mysql docker container %
# 1. run mysql docker container:	        docker container run -d --name mysqldb -p 3306:3306 -e MYSQL_ROOT_PASSWORD=123 mysql:latest
# 2. get mysql version container:           docker exec mysqldb mysql --version
# 3. login mysql container:                 docker exec -it mysqldb bash
# 4. specify login credentials: 	        mysql -u root -p123
# 5. show databases mysql container:        show databases;

#    % chatappbackend docker image %
# 1. create chatappbackend docker image:    docker build -t chatappbackend .

#    % spring-net docker network %
# 1. create spring-net network:             docker network create spring-net
# 2. list docker networks:                  docker network ls

#    % chatappbackend + mysql %
# 1. run chatappbackend:                    docker run -p 9090:8080 --name mysql:latest --net spring-net -e MYSQL_HOST=mysqldb -e MYSQL_USER=root -e MYSQL_PASSWORD=123 -e MYSQL_PORT=3306 chatappbackend