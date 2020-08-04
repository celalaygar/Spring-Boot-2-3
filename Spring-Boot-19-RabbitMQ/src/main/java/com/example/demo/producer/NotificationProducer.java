package com.example.demo.producer;

import java.util.Date;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.model.Notification;

@Service
public class NotificationProducer {
    @Value("${rabbitmq.routing.name}")
    private String routingName;

    @Value("${rabbitmq.exchange.name}")
    private String exchangeName;


    @PostConstruct
    public void init() {
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("First message is for rabbitmq");
        notification.setSeen(Boolean.FALSE);
        System.out.println("notification is loaded");
        sendToQueue(notification);
    }

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToQueue(Notification notification) {
        rabbitTemplate.convertAndSend(exchangeName, routingName, notification);
        System.out.println("Notification Sent ID : " + notification.getNotificationId());
    }
}
