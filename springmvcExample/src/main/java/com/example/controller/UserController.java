package com.example.controller;

import com.example.pojo.User;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
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
   /* public String add(@Valid User user, BindingResult br, HttpSession session, MultipartFile photo) throws IOException {*/
    public String add(@Valid User user, BindingResult br, HttpSession session, @RequestParam("photo") MultipartFile[] photoes) throws IOException {
        for (MultipartFile photo : photoes) {
            if (photo.isEmpty()) continue;//注意排除文件为空的情况
            String path = session.getServletContext().getRealPath("/statics/upload/");
            String filename = photo.getOriginalFilename();
            File file = new File(path + filename);
            FileUtils.copyInputStreamToFile(photo.getInputStream(), file);
        }

        //@NotNull验证
        if (br.hasErrors()) {
            return "/user/add";
        }
        users.put(user.getUsername(), user);
        return "redirect:/user/list";
    }

    @RequestMapping(value = "/{username}/show", method = RequestMethod.GET)
    public String show(@PathVariable String username, Model model) {
        User user = users.get(username);
        model.addAttribute("user", user);
        return "user/show";
    }

    @RequestMapping(value = "/{username}/show", method = RequestMethod.GET, params = "json")
    @ResponseBody
    public User show(@PathVariable String username, Model model, String diffParam) {
        User user = users.get(username);
        model.addAttribute("user", user);
        return user;
    }

    @RequestMapping(value = "/{username}/update", method = RequestMethod.GET)
    public String update(@PathVariable String username, Model model) {
        User user = users.get(username);
        model.addAttribute("user", user);
        return "user/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(User user) {
        users.put(user.getUsername(), user);
        return "redirect:/user/list";
    }

    @RequestMapping("/{username}/delete")
    public String delete(@PathVariable String username) {
        users.remove(username);
        return "redirect:/user/list";
    }

}
