package com.example.controller;

import com.example.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        users.put("renwujie", new User(1, "renwujie", "renshuji", "rwj@outlook.com"));
        users.put("sixin", new User(2, "sixin", "sizong", "sx@outlook.com"));
        users.put("wangxin", new User(3, "wangxin", "wanglaoban", "wx@outlook.com"));
    }

    @RequestMapping("/list")
    public String list(Model model) {
            model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        //在<sf:form>中给定modelAttribute属性时需要增加以下一行【重点是思路】
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(User user) {
        users.put(user.getUsername(), user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/{username}/show", method = RequestMethod.GET)
    public String show(@PathVariable String username, Model model) {
        User user = users.get(username);
        model.addAttribute("user", user);
        return "user/show";
    }
}
