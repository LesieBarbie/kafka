package com.example.user_consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/consumer")
    public String test() {
        return "User Consumer is working!";
    }
}
