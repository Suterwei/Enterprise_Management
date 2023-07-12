package com.project1.springboot.controller;


import com.project1.springboot.entity.Login;
import com.project1.springboot.entity.User;
import com.project1.springboot.mapper.LoginMapper;
import com.project1.springboot.mapper.UserMapper;
import com.project1.springboot.service.LoginService;
import com.project1.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginMapper loginMapper;

    @Autowired
    private LoginService loginService;

    @GetMapping("/{page}")
    public Map<String, Object> login(@RequestParam String name,
                                     @RequestParam String password) {
        boolean isValid = loginService.validateUser(name, password); // 调用非静态方法

        Map<String, Object> res = new HashMap<>();
        if (isValid) {
            res.put("message", "登录成功");
            res.put("status", "success");
        } else {
            res.put("message", "用户名或密码错误");
            res.put("status", "error");
        }
        return res;
    }
}


