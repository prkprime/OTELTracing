## OTEL Tracing demo

### Prerequisites
- jaeger up and running with HTTP OTEL collector port exposed

### Steps to run
1. create jar with ```mvn clean install```
2. run jar with ```JAEGER_COLLECTOR_URL="http://localhost:4318/v1/traces" java -jar target/Tracing-1.0-SNAPSHOT-jar-with-dependencies.jar``` (replace url with your jaeger instance url)