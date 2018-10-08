package com.packy.springboot2.unittest.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/test/home")
    public String home() {
        return "home";
    }
}
