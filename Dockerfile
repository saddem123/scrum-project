FROM openjdk:11
EXPOSE 8089
ADD target/examenScrum-1.0.0.jar examenScrum-1.0.0.jar
ENTRYPOINT ["java","-jar","/examenScrum-1.0.0.jar"]