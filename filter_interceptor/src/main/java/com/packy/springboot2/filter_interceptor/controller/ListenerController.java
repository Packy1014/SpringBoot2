package com.packy.springboot2.filter_interceptor.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListenerController {
    @GetMapping("request_listener")
    public String requestListen() {
        return "request listen success";
    }

    @GetMapping("context_listener")
    public String contextListen() {
        return "context listen success";
    }
}
