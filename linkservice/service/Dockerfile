FROM openjdk:17-jdk-slim

RUN mkdir /opt/app
WORKDIR /app
COPY ./target/linkservice*.jar /opt/app/app.jar

ENTRYPOINT ["java", "-DSERVER_PORT=$SERVER_PORT -DDB_PWD=DB_PWD -DDB_USER=$DB_USER -DDB_URL=$DB_URL", "-jar", "/opt/app/app.jar" ]

EXPOSE 8080
