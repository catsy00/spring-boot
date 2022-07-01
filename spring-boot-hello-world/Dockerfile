FROM default-route-openshift-image-registry.apps.ocd1.shinhan.local/openshift/ubi8-openjdk-11-runtime:1.10
USER root
COPY ./spring-boot-hello-1.0.jar .
# CMD chmod 777 spring-boot-hello-1.0.jar
# USER jboss
# CMD java -jar spring-boot-hello-1.0.jar
CMD /bin/sh -c "while true ; do date; sleep 1; done;"
