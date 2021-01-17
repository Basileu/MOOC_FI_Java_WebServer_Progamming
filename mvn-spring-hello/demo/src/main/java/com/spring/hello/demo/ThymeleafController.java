package com.spring.hello.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {

    @GetMapping("/")
    public String home() {
        return "index";
    }
}