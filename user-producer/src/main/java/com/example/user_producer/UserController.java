package com.example.user_producer;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final KafkaTemplate<String, UserCreated> kafka;

    public UserController(KafkaTemplate<String, UserCreated> kafka) {
        this.kafka = kafka;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody UserCreated user) {
        kafka.send("user.created", user.email(), user);
        return ResponseEntity.ok("Подію відправлено у Kafka");
    }
}
