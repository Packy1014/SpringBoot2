package com.packy.springboot2.redis.controller;


import com.packy.springboot2.redis.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/redis")
public class RedisTestController {

    private final StringRedisTemplate stringRedisTemplate;

    @Autowired
    public RedisTestController(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    @GetMapping(value = "add/{key}/{value}")
    public Object add(@PathVariable String key, @PathVariable String value) {
        stringRedisTemplate.opsForValue().set(key, value);
        return JsonData.buildSuccess("OK");
    }

    @GetMapping(value = "get/{key}")
    public Object get(@PathVariable String key) {
        String value = stringRedisTemplate.opsForValue().get(key);
        return JsonData.buildSuccess(value);
    }

    @GetMapping(value = "delete/{key}")
    public Object delete(@PathVariable String key) {
        stringRedisTemplate.delete(key);
        return JsonData.buildSuccess("Deleted");
    }

}
