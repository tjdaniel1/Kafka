package com.example.test1.controller;

import com.example.test1.dto.User;
import com.example.test1.kafka.UserProducer;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {
    private final UserProducer producer;

    @PostMapping
    public void testSendIn(@RequestBody User user){
        producer.send(user, "insert" );
    }
    @PutMapping
    public void testSendUp(@RequestBody User user){
        producer.send(user, "update" );
    }
    @DeleteMapping
    public void testSendDel(@RequestBody User user){
        producer.send(user, "delete" );
    }

    public TestController(UserProducer producer) {
        this.producer = producer;
    }
}