package com.example.seat_choosingmain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestHello {
    @RequestMapping("/")
    public String sayHello() {
        return "Hello World!!!!!";
    }
}