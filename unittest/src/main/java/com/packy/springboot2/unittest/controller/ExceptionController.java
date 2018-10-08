package com.packy.springboot2.unittest.controller;

import com.packy.springboot2.unittest.exception.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    @GetMapping("/test/exception")
    public String exception() {
        int i = 1 / 0;
        return "home";
    }

    @GetMapping("/test/my_exception")
    public String myException() {
        throw new MyException("110", "MyException");
    }
}
