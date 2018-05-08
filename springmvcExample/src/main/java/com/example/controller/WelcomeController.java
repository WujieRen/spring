package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renwujie on 2018/05/08 at 19:25
 */
@Controller
public class WelcomeController {
    @RequestMapping({"/welcome", "/wel"})
    /*public String welcome(@RequestParam String username) {*/
    public String welcome(String username) {
        System.out.println("Welcome");
        System.out.println(username);
        return "welcome";
    }

    @RequestMapping("/login")
    /*public String login(String username, Map<String, String> ctx) {*/
    public String login(String username, Model model) {
        /*ctx.put("username", username);*/
        /*model.addAttribute("username", username);*/
        /**
         * 如果model.addAttribute没有key,则会使用value的数据类型作为key(首字母小写)
         */
        model.addAttribute(username);
        Map<String, String> maps = new HashMap<String, String>();
        maps.put("rwj", "renwujie");
        maps.put("fy", "fengyu");
        maps.put("ww", "wenwen");
        model.addAttribute("map",maps);

        return "welcome";
    }
}
