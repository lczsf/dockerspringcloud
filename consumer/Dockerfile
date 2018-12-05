FROM java:8
MAINTAINER lc <JwebSmile@lc.com>

VOLUME /tmp
ADD /target/consumer.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8000
ENTRYPOINT ["java","-jar","/app.jar"]
