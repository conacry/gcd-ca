FROM adoptopenjdk:11-jre-hotspot
RUN mkdir -p /opt/gcd-ca
COPY /target/gcd-ca-*.jar /opt/gcd-ca/gcd-ca-app.jar
WORKDIR /opt/gcd-ca
ENTRYPOINT java -jar gcd-ca-app.jar