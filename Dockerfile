FROM amazoncorretto:21-alpine-jdk
COPY target/Tracing-1.0-SNAPSHOT-jar-with-dependencies.jar Tracing-1.0-SNAPSHOT-jar-with-dependencies.jar
ENV JAEGER_COLLECTOR_URL="http://jaeger:4317"
ENTRYPOINT ["java","-jar","Tracing-1.0-SNAPSHOT-jar-with-dependencies.jar"]