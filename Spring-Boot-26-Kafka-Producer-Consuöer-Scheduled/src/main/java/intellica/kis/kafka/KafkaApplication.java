package intellica.kis.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaApplication {



	public static void main(String[] args) {
		SpringApplication.run(KafkaApplication.class, args);
	}

}
