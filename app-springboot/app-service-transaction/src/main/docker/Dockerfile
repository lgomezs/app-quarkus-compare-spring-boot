FROM openjdk:11-jre-slim
LABEL maintainer="Luis Miguel Gomez Saavedra"

WORKDIR /opt/
ADD  *-app-*.jar /opt/app.jar
ADD https://repo1.maven.org/maven2/co/elastic/apm/elastic-apm-agent/1.7.0/elastic-apm-agent-1.7.0.jar elastic-apm-agent.jar

EXPOSE 8090
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -XshowSettings:vm\
                -javaagent:elastic-apm-agent.jar \
                -Dspring.profiles.active=$PROFILE \
                -Delastic.apm.enable_log_correlation=true \
                -Delastic.apm.service_name=$APPLICATION_NAME \
                -Dinstrument=false \
                -Delastic.apm.server_urls=http://$APM_SERVER_URL:$APM_SERVER_URL_PORT \
                -jar app.jar"]