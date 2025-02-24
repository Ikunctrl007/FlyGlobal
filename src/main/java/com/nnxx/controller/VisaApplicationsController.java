package com.nnxx.controller;


import com.nnxx.domain.Result;
import com.nnxx.domain.dto.VisaApplicationsDto;
import com.nnxx.domain.dto.VisaApplicationsVisaDto;
import com.nnxx.domain.po.VisaApplications;
import com.nnxx.service.IVisaApplicationsService;
import com.nnxx.util.JwtUtils;
import com.nnxx.util.ParseTokenUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 签证申请表 前端控制器
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 * 1. 普通用户新增签证申请
 * 2. 普通用户查询自己的签证申请
 * 3. 签证官员修改申请
 * 4. 签证官员根据用户ID查询申请
 * 5. 超级管理员可以删除，修改，查询所有用户申请
 */
@RestController
@RequestMapping("/visa-applications")
public class VisaApplicationsController {
    @Autowired
    private IVisaApplicationsService service;
    //普通用户新增签证申请
    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping
    public Result insert(@RequestHeader("Authorization")String token, @RequestBody VisaApplicationsDto visaApplicationsDto){
        //获取请求头里的userid
        Long id = ParseTokenUtils.parseToken(token);
        visaApplicationsDto.setUserId(id);
        return service.insert(visaApplicationsDto);
    }
    //普通用户查询自己的签证申请
    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/user")
    public Result selectByUser(@RequestHeader("Authorization")String token){
        Long id = ParseTokenUtils.parseToken(token);
        return service.selectByUser(id);
    }
    //签证官员查询自己的申请
    @PreAuthorize("hasAnyAuthority('VISA_OFFICER')")
    @GetMapping("/list")
    public Result selectById(@RequestHeader("Authorization")String token){
        Long id = ParseTokenUtils.parseToken(token);
        return service.selectById(id);
    }
    //签证官员根据申请状态查询
    @PreAuthorize("hasAnyAuthority('VISA_OFFICER')")
    @GetMapping("/officer/{status}")
    public Result selectAllByStatus(@PathVariable("status") int id){
        return service.selectAllByStatus(id);
    }
    //签证官员修改申请
    @PreAuthorize("hasAnyAuthority('VISA_OFFICER')")
    @PutMapping
    public Result updateByApplicationId(@RequestBody VisaApplicationsVisaDto visaApplicationsVisaDto){
        return service.updateByApplicationId(visaApplicationsVisaDto);
    }
    //查询所有用户申请
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @GetMapping("/admin")
    public Result selectAll(){
        return service.selectAll();
    }
    //删除
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @DeleteMapping("/admin/id/{id}")
    public Result deleteById(@PathVariable("id") Long id){
        return service.deleteById(id);
    }
    //修改
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @PutMapping("/admin")
    public Result updateByApplication(@RequestBody VisaApplications visaApplications){
        return service.updateByApplication(visaApplications);
    }
    //添加
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @PostMapping("/admin")
    public Result insertVisaApplication(@RequestBody VisaApplications visaApplications){
        return service.insertVisaApplication(visaApplications);
    }
}
