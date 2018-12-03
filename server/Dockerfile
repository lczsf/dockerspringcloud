FROM maven:3.6-jdk-8-alpine
MAINTAINER lc <JwebSmile@lc.com>

COPY . /app
WORKDIR /app
EVN EUREKA_HOST=127.0.0.1
EVN EUREKA_PORT=8761
RUN mvn  -B -DskipTests=true -Dmaven.repo.local=/tmp/cache clean install

CMD ["java", "-Xmx200m","-jar", "/app/target/server.jar"]

EXPOSE 8761
