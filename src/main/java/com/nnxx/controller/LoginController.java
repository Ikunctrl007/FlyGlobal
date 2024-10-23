package com.nnxx.controller;

import com.nnxx.domain.Result;
import com.nnxx.domain.po.Users;
import com.nnxx.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//登录与退出登录
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public Result login(@RequestBody Users user){
        return loginService.login(user);
    }

}
