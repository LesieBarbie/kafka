package com.example.user_consumer;

import com.example.user_consumer.UserCreated;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class GreetingConsumer {
    @KafkaListener(topics = "user.created", groupId = "greetings")
    public void listen(UserCreated u) {
        System.out.printf("Вітаємо, %s (%s)!%n", u.name(), u.email());
    }
}
