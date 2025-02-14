// src/main/java/com/example/demo/controller/HelloController.java
package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot on M2 Mac Studio!";
    }
    @GetMapping("/")
    public String index() {
        return "This is the index page!";
    }
}

