FROM openjdk:11-jre-slim
ADD ./kafka-mail-sender/target/kafka-mail-sender.jar kafka-mail-sender.jar
ENTRYPOINT ["java", "-jar", "kafka-mail-sender.jar"]