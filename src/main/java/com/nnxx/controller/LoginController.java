package com.nnxx.controller;

import com.nnxx.domain.LoginUser;
import com.nnxx.domain.Result;
import com.nnxx.domain.po.Users;
import com.nnxx.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private LoginService service;
    @PostMapping
    public Result login(@RequestBody Users users){
        return service.login(users);
    }
}
