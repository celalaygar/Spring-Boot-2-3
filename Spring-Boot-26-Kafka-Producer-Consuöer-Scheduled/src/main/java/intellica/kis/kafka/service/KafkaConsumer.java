package intellica.kis.kafka.service;


import intellica.kis.kafka.config.KafkaConstant;
import intellica.kis.kafka.dto.DataDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @Value("${kafka.topic}")
    private String kafkaTopic;

    @Value("${kafka.group}")
    private String kafkaGroup;

    @KafkaListener(topics = KafkaConstant.KAFKA_TOPIC, groupId = KafkaConstant.KAFKA_GROUP_ID)
    public void consume(String message) {
        System.out.println("Consumer");
        System.out.println("Consumer : received message = " + message);
    }
}
