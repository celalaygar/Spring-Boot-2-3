package intellica.kis.kafka.service;

import intellica.kis.kafka.dto.DataDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class KafkaProducer {
    @Value("${kafka.topic}")
    private String kafkaTopic;

    @Value("${kafka.group}")
    private String kafkaGroup;
    private static Integer i = 0;


    private final KafkaTemplate<String, String> kafkaTemplate;
    private final KafkaTemplate<String, DataDto> kafkaTemplate2;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, KafkaTemplate<String, DataDto> kafkaTemplate2) {
        this.kafkaTemplate = kafkaTemplate;
        this.kafkaTemplate2 = kafkaTemplate2;
    }


    public void send(String message) throws Exception {

        kafkaTemplate.send(kafkaTopic, message);
        System.out.println("Succeed send message to KAFKA_TOPIC : " + kafkaTopic);
    }

    public void sendObject(DataDto dto) throws Exception {

        kafkaTemplate2.send(kafkaTopic, dto);
        System.out.println("Succeed send message to KAFKA_TOPIC : " + kafkaTopic);
    }

    //@Scheduled(cron="*/5 * * * * MON-FRI")
    //@Scheduled(fixedRate = 24, timeUnit = TimeUnit.HOURS)
    //@Scheduled(cron = "0 0 9,10 * * *") her gün saat 9 ve 10 da çalışır.
    @Scheduled(cron = "0 45 15 * * *")
    public void scheduled( ) throws Exception {
        i++;
        DataDto dto = new DataDto();
        dto.setId(i);
        dto.setDataName("Scheduled : " + i);
        kafkaTemplate2.send(kafkaTopic, dto);
        System.out.println("Succeed send message to KAFKA_TOPIC : " + kafkaTopic);
    }
}
