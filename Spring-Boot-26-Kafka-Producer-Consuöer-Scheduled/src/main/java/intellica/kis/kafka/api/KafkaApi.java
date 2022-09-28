package intellica.kis.kafka.api;


import intellica.kis.kafka.dto.DataDto;
import intellica.kis.kafka.service.KafkaProducer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaApi {


    private final KafkaProducer kafkaSender;

    public KafkaApi(KafkaProducer kafkaSender) {
        this.kafkaSender = kafkaSender;
    }

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("message") String message) throws Exception {
        kafkaSender.send(message);

        return "Message is sent to the Kafka Topic java_in_use_topic Successfully : <br/>"+ message;
    }
    @PostMapping(value = "/producer")
    public String producer2(@RequestBody DataDto dto) throws Exception {
        kafkaSender.sendObject(dto);

        return "Request Body is sent to the Kafka Topic java_in_use_topic Successfully : <br/>"+ dto;
    }

}
