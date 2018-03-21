package com.enote.notebook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/notebook")
    public String sayHello() {
        return "Works fine: " + name;
    }
}
