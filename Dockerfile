FROM openjdk:8-jre-alpine3.7
WORKDIR /
ADD RestApiMail-0.0.1-SNAPSHOT RestApiMail-0.0.1-SNAPSHOT
ADD config.yml config.yml
ADD docker-entrypoint.sh docker-entrypoint.sh
RUN chmod a+x docker-entrypoint.sh
EXPOSE 8080
ENTRYPOINT ["/docker-entrypoint.sh"]