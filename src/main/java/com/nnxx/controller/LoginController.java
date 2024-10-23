package com.nong.controller;

import com.nong.domain.Result;
import com.nong.domain.UserInformation;
import com.nong.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//登录与退出登录
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/login")
    public Result login(@RequestBody UserInformation user){
        return loginService.login(user);
    }

    @PostMapping("/logout")
    public Result logout(){
        return loginService.logout();
    }
}
