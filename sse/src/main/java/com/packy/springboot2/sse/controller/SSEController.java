package com.packy.springboot2.sse.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sse")
public class SSEController {

    @RequestMapping(value = "/push_price", produces = "text/event-stream;charset=UTF-8")
    public String pushPrice() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data: " + Math.random() + "\n\n";
    }
}
