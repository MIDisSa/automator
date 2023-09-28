FROM openjdk:17-jdk-alpine3.13

RUN apk update
RUN apk add openjdk8-jre unzip wget bash

WORKDIR /app

COPY . .

RUN wget https://ccl.northwestern.edu/netlogo/6.2.2/NetLogo-6.2.2-64.tgz -O /app/NetLogo-6.2.2-64.tgz
RUN tar xzf NetLogo-6.2.2-64.tgz
RUN mv "NetLogo 6.2.2" NetLogo-6.2.2

CMD ["java", "-jar", "target/automator-0.0.1-SNAPSHOT.jar" ]