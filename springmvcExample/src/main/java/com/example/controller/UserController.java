package com.example.controller;

import com.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by renwujie on 2018/05/08 at 21:59
 */
@Controller
@RequestMapping("/user")
public class UserController {

    Map<String, User> users = new HashMap<>();

    public UserController() {
        users.put("rwj", new User(1, "renwujie", "renshuji", "rwj@outlook.com"));
        users.put("sx", new User(2, "sixin", "sizong", "sx@outlook.com"));
        users.put("wx", new User(3, "wangxin", "wanglaoban", "wx@outlook.com"));
    }

    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("users", users);
        return "user/list";
    }
}
