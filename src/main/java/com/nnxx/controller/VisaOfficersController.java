package com.nnxx.controller;


import com.nnxx.domain.Result;
import com.nnxx.domain.po.ImmigrationLawyers;
import com.nnxx.domain.po.VisaOfficers;
import com.nnxx.service.IImmigrationLawyersService;
import com.nnxx.service.IVisaOfficersService;
import com.nnxx.util.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 签证官员表 前端控制器
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@RestController
@RequestMapping("/visa-officers")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('VISA_OFFICER')")
public class VisaOfficersController {
    private final IVisaOfficersService service;

    @PostMapping
    public Result insert(@RequestBody VisaOfficers visaOfficers,@RequestHeader("Authorization") String token){
        String str = token.substring(7);
        //获取到的Token里解析出userid
        Claims claims = JwtUtils.parseJWT(str);
        Long id = Long.valueOf(claims.get("Token").toString());
        visaOfficers.setUserId(id);
        return service.insertOne(visaOfficers);
    }
    @PutMapping
    public Result update(@RequestBody VisaOfficers visaOfficers ){
        return service.updateOne(visaOfficers);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    //需要超级管理员才可以调用这个方法
    public Result delete(@PathVariable("id") Integer id){
        return service.delete(id);
    }
    @GetMapping
    public Result selectOne(@RequestHeader("Authorization") String token){
        String str = token.substring(7);
        //获取到的Token里解析出userid
        Claims claims = JwtUtils.parseJWT(str);
        long id = Long.parseLong(claims.get("Token").toString());
        return service.selectOne((int) id);
    }
    @GetMapping("/list")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    //超级管理员可以查看所有的留学顾问
    public Result selectAll(){
        return service.selectAll();
    }
}
