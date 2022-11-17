package com.example.demotest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping
    public EntityNew get() {
        return new EntityNew();
    }
}
