package com.example.controller;

import com.example.exception.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by renwujie on 2018/05/09 at 19:00
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //方法的参数要和jsp页面中组建的名字相同
    public String login(String username, String password) {
        if("admin".equals(username)) {
            if("123456".equals(password)) {

            }
            else {
                throw new UserException("密码错误!");
            }
        }
        else {
            throw new UserException("用户名错误");
        }

        return "redirect:user/list";
    }

    //局部异常
    /*@ExceptionHandler(UserException.class)
    public String handlerException(UserException ex, Model model) {
        model.addAttribute("ex", ex);
        return "inc/error";
    }*/
}
