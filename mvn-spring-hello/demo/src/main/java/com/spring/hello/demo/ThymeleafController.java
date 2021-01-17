package com.spring.hello.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ThymeleafController {

    private List<String> list;
    
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("paramName0", "Hei Mambo!");
        model.addAttribute("paramName1", "Mambo italiano!");

        model.addAttribute("list", list);

        return "index";
    }

    public ThymeleafController() {
        this.list = new ArrayList<>();
        list.add("Hello world");
        this.list.add("+[-[<<[+[--->]-[<<<]]]>>>-]>-.---.>..>.<<<<-.<+.>>>>>.>.<<.<-.");
    }
}