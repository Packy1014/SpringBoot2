package com.packy.springboot2.filter_interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterceptorController {
    @GetMapping("api2/interceptor/logout")
    public String login() {
        return "logout success";
    }
}
