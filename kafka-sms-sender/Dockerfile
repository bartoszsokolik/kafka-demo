FROM openjdk:11-jre-slim
ADD ./kafka-sms-sender/target/kafka-sms-sender.jar kafka-sms-sender.jar
ENTRYPOINT ["java", "-jar", "kafka-sms-sender.jar"]