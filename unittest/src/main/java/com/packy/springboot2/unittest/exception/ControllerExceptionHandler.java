package com.packy.springboot2.unittest.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public Map<String, String> handleException(Exception e, HttpServletRequest request) {
        Map<String, String> result = new HashMap<>();
        result.put("msg", "error");
        return result;
    }

    @ExceptionHandler(value = MyException.class)
    public ModelAndView handleMyException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error.html");
        modelAndView.addObject("msg", e.getMessage());
        return modelAndView;
    }
}
