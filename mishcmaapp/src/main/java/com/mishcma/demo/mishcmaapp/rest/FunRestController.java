package com.mishcma.demo.mishcmaapp.rest;

import java.time.LocalDateTime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello() {
        return "Hello World! Time on server is " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Do smth 5 times daily!";
    }

    @GetMapping("/workout1")
    public String getDailyWorkout1() {
        return "Do smth 5 times daily!";
    }




}
