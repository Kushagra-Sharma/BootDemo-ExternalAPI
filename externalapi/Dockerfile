FROM openjdk:8
EXPOSE 8080
ADD target/boot-docker.jar boot-docker.jar
ENTRYPOINT ["java","-jar","/boot-docker.jar"]