FROM registry.redhat.io/ubi8/openjdk-17:1.13-1.1655306439 AS builder
COPY ./pom.xml .
COPY ./src ./src
RUN mkdir target
RUN mvn package
# CMD /bin/sh -c "while true ; do date; sleep 1; done;"

FROM registry.redhat.io/ubi8/openjdk-17-runtime:1.13-1.1655306380
COPY --from=builder ./target/spring-boot-hello-1.0.jar app.jar
EXPOSE 8080
CMD java -jar app.jar
# CMD chmod 777 spring-boot-hello-1.0.jar
# USER jboss
# CMD java -jar spring-boot-hello-1.0.jar
# CMD /bin/sh -c "while true ; do date; sleep 1; done;"
