package com.project1.springboot.service;

import com.project1.springboot.entity.Login;
import com.project1.springboot.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginService {
    private final LoginMapper loginMapper;

    @Autowired
    public LoginService(LoginMapper loginMapper) {
        this.loginMapper = loginMapper;
    }

    public boolean validateUser(String name, String password) {
        Login login = loginMapper.findByUsername(name);
        if (login != null && login.getPassword().equals(password)) {
            return true;
        }
        return false;
    }
}

