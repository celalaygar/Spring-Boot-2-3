package com.example.demo.consumer;

import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Notification;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class NotificationConsumer {
	
	
	private final  Logger logger;
	
    @RabbitListener(queues = "queue")    
    public void handleMessage(Notification notification) {
        System.out.println("Message received..");
        logger.info("Message received..");
        System.out.println(notification.toString());
    }
}
