package com.nnxx.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    @PreAuthorize("hasAnyAuthority('user')")
    public String hello(){
        System.out.println("Hello World!!!");
        return "Hello World";
    }
}
