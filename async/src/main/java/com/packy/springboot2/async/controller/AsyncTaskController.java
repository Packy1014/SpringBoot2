package com.packy.springboot2.async.controller;

import com.packy.springboot2.async.domain.AsyncTask;
import com.packy.springboot2.async.domain.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;


@RestController
@RequestMapping("/api")
public class AsyncTaskController {

    private final AsyncTask asyncTask;

    @Autowired
    public AsyncTaskController(AsyncTask asyncTask) {
        this.asyncTask = asyncTask;
    }

    @GetMapping("async_task")
    public JsonData exeTask() throws InterruptedException {

        long begin = System.currentTimeMillis();

        asyncTask.task1();
        asyncTask.task2();
        asyncTask.task3();

        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();
        Future<String> task6 = asyncTask.task6();
        while (true) {
            if (task4.isDone() && task5.isDone() && task6.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();

        long total = end - begin;
        System.out.println("执行总耗时=" + total);
        return JsonData.buildSuccess(total);
    }

}

