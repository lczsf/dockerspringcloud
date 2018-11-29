FROM maven:3.6-jdk-8-alpine
MAINTAINER lc <JwebSmile@lc.com>
RUN mvn  -B -DskipTests=true -Dmaven.repo.local=/tmp/cache clean install

COPY . /app
WORKDIR /app

CMD ["java", "-Xmx200m","-jar", "/app/target/file-service.jar"]

EXPOSE 7000
