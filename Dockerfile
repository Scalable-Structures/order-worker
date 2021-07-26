FROM openjdk

WORKDIR /app

COPY target/order-worker-0.0.1-SNAPSHOT.jar /app/order-worker.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","order-worker.jar"]