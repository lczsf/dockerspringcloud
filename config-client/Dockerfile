FROM maven:3.6-jdk-8-alpine
MAINTAINER lc <JwebSmile@lc.com>

COPY . /app
WORKDIR /app

CMD ["java", "-Xmx200m","-jar", "/app/config-client.jar"]

EXPOSE 9000
