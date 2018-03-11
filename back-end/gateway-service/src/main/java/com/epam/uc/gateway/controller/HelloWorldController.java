package com.epam.uc.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

  @GetMapping("/helloWorld")
  public String sayHello() {
    return "Works fine";
  }
}