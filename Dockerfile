FROM alpine:edge
MAINTAINER coarsehorse
RUN apk add --no-cache \
    openjdk17 \
    maven
COPY . /info-polus-task
WORKDIR /info-polus-task
RUN mvn clean install
WORKDIR /info-polus-task/target
ENTRYPOINT ["/usr/bin/java"]
CMD ["-jar", "info-polus-task-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
