FROM java:8
MAINTAINER lc <JwebSmile@lc.com>

VOLUME /tmp
ADD /target/provider.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 8011
ENTRYPOINT ["java","-jar","/app.jar"]
