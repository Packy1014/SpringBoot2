package com.packy.SpringBoot2.webflux.controller;


import com.packy.SpringBoot2.webflux.domain.User;
import com.packy.SpringBoot2.webflux.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/user")
public class UserController {

    //@Autowired
    //private UserService userService;

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @GetMapping("test")
    public Mono<String> test() {
        return Mono.just("hello world");
    }

    @GetMapping("find")
    public Mono<User> findById(final String id) {
        return userService.getById(id);
    }

    @GetMapping("del")
    public Mono<User> del(final String id) {
        return userService.del(id);
    }

    @GetMapping(value = "list", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<User> list() {
        return userService.list().delayElements(Duration.ofSeconds(2));
    }

}
