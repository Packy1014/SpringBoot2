package com.packy.springboot2.directory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {
    @GetMapping("index")
    public String index() {
        return "index";
    }
}
