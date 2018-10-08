package com.packy.springboot2.filter_interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilterController {
    @GetMapping("api/filter/login")
    public String login() {
        return "login success";
    }
}
