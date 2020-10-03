package com.gyb.springbootcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author gb
 * @Date 2020/9/26 23:14
 * @Version 1.0
 * description:登陆
 */
@Controller
public class LoginController {

    @GetMapping(value = "/user/login")
    public String login(@RequestParam("username") String userName, @RequestParam("password") String password, Map<String, Object> map, HttpSession httpSession) {
        if (!StringUtils.isEmpty(userName)) {
            httpSession.setAttribute("loginUser", userName);
            return "redirect:/main.html";
        } else {
            map.put("msg", "用户名或者密码错误");
            return "index";
        }

    }
}
