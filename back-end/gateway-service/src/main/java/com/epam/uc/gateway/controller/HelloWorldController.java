package com.epam.uc.gateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

  @Value("#{property.to.check}")
  private String property;

  @GetMapping("/helloWorld")
  public String sayHello() {
    return "Works fine with profile dev:" + property;
  }
}
