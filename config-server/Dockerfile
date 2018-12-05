FROM java:8
MAINTAINER lc <JwebSmile@lc.com>

VOLUME /tmp
ADD /target/config-server.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8888
ENTRYPOINT ["java","-jar","/app.jar"]
