FROM java:8
MAINTAINER lc <JwebSmile@lc.com>

VOLUME /tmp
RUN mvn clean package docker:build
ADD /target/server.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8000
ENTRYPOINT ["java","-Dspring.profiles.active=server-1","-jar","/app.jar"]
