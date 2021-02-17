FROM openjdk:8

# ----
# Install Maven
# RUN apk add --no-cache curl tar bash
ARG MAVEN_VERSION=3.6.3
ARG USER_HOME_DIR="/root"
WORKDIR /
RUN apt -y update
RUN apt -y install maven

# get project dependencies (not required as copying full src)
# COPY pom.xml /210108_cucumber/

# get source code
COPY . /210128_CodeKata/

# build with maven
WORKDIR /210128_CodeKata/

# this doesn't prevent mvn package from downloading everything everytime...?
#### RUN mvn dependency:go-offline

RUN mvn package

# reset workdir
WORKDIR /

# Default command
ENTRYPOINT ["java", "-cp", "210128_CodeKata/target/210128_CodeKata-0.0.1-SNAPSHOT.jar", "com.posco.RunApp"]

