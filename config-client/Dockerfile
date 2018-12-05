FROM java:8
MAINTAINER lc <JwebSmile@lc.com>

VOLUME /tmp
ADD /target/config-client.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 9000
ENTRYPOINT ["java","-jar","/app.jar"]
