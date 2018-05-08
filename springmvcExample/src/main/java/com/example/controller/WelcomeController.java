package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by renwujie on 2018/05/08 at 19:25
 */
@Controller
public class WelcomeController {
    @RequestMapping({"/welcome", "/wel"})
    public String welcome() {
        System.out.println("Welcome");
        return "welcome";
    }
}
