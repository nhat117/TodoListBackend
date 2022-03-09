FROM --platform=linux/amd64 openjdk:11
EXPOSE 9090
ADD target/task-api.jar task-api.jar
ENTRYPOINT ["java","-jar","task-api.jar"]