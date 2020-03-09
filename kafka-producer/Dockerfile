FROM openjdk:11-jre-slim
ADD ./kafka-producer/target/kafka-producer.jar kafka-producer.jar
ENTRYPOINT ["java", "-jar", "kafka-producer.jar"]