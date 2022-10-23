FROM openjdk

WORKDIR /app

COPY out/artifacts/java_server_jar/java-server.jar /app/app.jar

ENTRYPOINT ["java","-jar","app.jar"]