package com.example.user_producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/producer")
    public String test() {
        return "User Producer is working!";
    }
}
