package com.example.testing.controller;

import com.example.testing.service.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloController {

    @Reference
    private HelloService helloService;

    @Value("${local.name}")
    private String name;

    @GetMapping("/hello")
    public String hello() {
        return helloService.hello(name);
    }
}
