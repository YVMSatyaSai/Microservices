package com.game.firefire;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = "user-topic", groupId = "my-group")
    public void consume(String message) {
        System.out.println("🔥 Received from Kafka: " + message);
    }
}
