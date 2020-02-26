FROM openjdk:8-jdk-alpine

LABEL source="https://github.com/health2gether/health2gether-user" \
      maintainer="flavioso16@gmail.com"

ADD ./target/user-0.0.1-SNAPSHOT.jar user.jar
ADD ./docker-entrypoint.sh /

RUN chmod +x /docker-entrypoint.sh

EXPOSE 8082

ENTRYPOINT ["/docker-entrypoint.sh"]