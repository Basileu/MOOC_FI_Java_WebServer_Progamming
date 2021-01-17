package com.spring.hello.demo;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @GetMapping("/integer")
    @ResponseBody
    public String integerParam(@RequestParam Integer param) {
        return "Hello World! Integer param = " + param;
    }
    @GetMapping("/noparam")
    @ResponseBody
    public String noparam(@RequestParam Map<String, String> myMap) {
        StringBuilder myB = new StringBuilder();
        for (String key: myMap.keySet()) {
            myB.append(key);
            myB.append(myMap.get(key));
        }
        return "Hello World!" + myB.toString();
    }
    @GetMapping("/index.html")
    @ResponseBody
    public String home(@RequestParam String Marcel, String Ionel) {
        return "Hello World!" + " Marcel=" + Marcel + " Ionel = " + Ionel;
    }
    @GetMapping("/path")
    @ResponseBody
    public String path() {
        return "You have accessed: (path)";
    }

    @GetMapping("/route")
    @ResponseBody
    public String route() {
        return "You have accessed: (route)";
    }

    @GetMapping("/trail")
    @ResponseBody
    public String trail() {
        return "You have accessed:  (trail)";
    }    
}
