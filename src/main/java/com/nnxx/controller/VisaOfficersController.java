package com.nnxx.controller;


import com.nnxx.domain.Result;
import com.nnxx.domain.po.ImmigrationLawyers;
import com.nnxx.domain.po.VisaOfficers;
import com.nnxx.service.IImmigrationLawyersService;
import com.nnxx.service.IVisaOfficersService;
import com.nnxx.util.JwtUtils;
import com.nnxx.util.ParseTokenUtils;
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

public class VisaOfficersController {
    private final IVisaOfficersService service;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('VISA_OFFICER')")
    public Result insert(@RequestBody VisaOfficers visaOfficers,@RequestHeader("Authorization") String token){
        Long id = ParseTokenUtils.parseToken(token);
        visaOfficers.setUserId(id);
        return service.insertOne(visaOfficers);
    }
    @PutMapping
    @PreAuthorize("hasAnyAuthority('VISA_OFFICER')")
    public Result update(@RequestBody VisaOfficers visaOfficers ){
        return service.updateOne(visaOfficers);
    }
    @DeleteMapping("/admin/id/{id}")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    //需要超级管理员才可以调用这个方法
    public Result delete(@PathVariable("id") Integer id){
        return service.delete(id);
    }
    @GetMapping
    @PreAuthorize("hasAnyAuthority('VISA_OFFICER')")
    public Result selectOne(@RequestHeader("Authorization") String token){
        Long id = ParseTokenUtils.parseToken(token);
        return service.selectOne(id);
    }
    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('USER')")
    //超级管理员可以查看所有的留学顾问
    public Result selectAll(){
        return service.selectAll();
    }
}
