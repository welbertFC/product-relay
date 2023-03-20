FROM openjdk
WORKDIR /app
COPY build/libs/product-relay-0.0.1-SNAPSHOT.jar /app/product-relay.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","product-relay.jar"]
