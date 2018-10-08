package com.packy.springboot2.war.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/war")
public class WarController {

    @GetMapping("/test")
    public String test(){
        return "war";
    }
}
