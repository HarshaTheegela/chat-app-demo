FROM maven:3.5-jdk-8-alpine

ADD src /demo/src
ADD pom.xml /demo
ADD wait.sh /demo
ADD entrypoint.sh /demo


EXPOSE 8080

#VOLUME /tmp

WORKDIR /demo

RUN mvn clean install

#ENTRYPOINT ["java","-jar","target/chat-app-demo-0.0.1-SNAPSHOT.jar"]

ENTRYPOINT ["/demo/entrypoint.sh"]
