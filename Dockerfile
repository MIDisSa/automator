FROM openjdk:17-slim-buster

RUN apt-get update && apt-get install -y \
    wget \
    unzip \
    bash \
    python3 \
    python3-dev \
    python3-pip

WORKDIR /app

COPY . .

COPY requirements.txt .
RUN pip3 install -U pip
RUN pip3 install -r requirements.txt

RUN wget https://ccl.northwestern.edu/netlogo/6.2.2/NetLogo-6.2.2-64.tgz -O /app/NetLogo-6.2.2-64.tgz
RUN tar xzf NetLogo-6.2.2-64.tgz
RUN mv "NetLogo 6.2.2" NetLogo-6.2.2

CMD ["java", "-jar", "target/automator-0.0.1-SNAPSHOT.jar"]
