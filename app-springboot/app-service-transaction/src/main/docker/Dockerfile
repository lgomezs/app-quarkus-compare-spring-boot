FROM openjdk:11-jre-slim
LABEL maintainer="Luis Miguel Gomez Saavedra"

WORKDIR /opt/
ADD  *-app-*.jar /opt/app.jar

EXPOSE 8090
ENTRYPOINT ["sh", "-c"]
CMD ["exec java -XshowSettings:vm\
                -jar app.jar"]