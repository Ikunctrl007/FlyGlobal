package com.nnxx.controller;


import com.nnxx.domain.Result;
import com.nnxx.domain.dto.ImmigrationDto;
import com.nnxx.domain.dto.ImmigrationServicesDto;
import com.nnxx.service.IImmigrationServicesService;
import com.nnxx.util.JwtUtils;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 移民咨询与服务表 前端控制器
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 * 普通用户可以添加与查询移民咨询表，可以根据返回的建议修改移民咨询表 NORMAL_USER
 * 律师可以查询、修改咨询表，修改后会通知用户 IMMIGRATION_LAWYER
 * 超级管理员可以增删改查移民咨询表 SUPER_ADMINISTRATOR
 */
@RestController
@RequestMapping("/immigration-services")
@RequiredArgsConstructor
public class ImmigrationServicesController {

    private final IImmigrationServicesService service ;
    //普通用户可以添加咨询表
    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping
    public Result insert(@RequestHeader("Authorization")String token, @RequestBody ImmigrationServicesDto immigrationServicesDto){
        //获取请求头里的userid
        String substring = token.substring(7);
        Claims claims = JwtUtils.parseJWT(substring);
        Object userid = claims.get("Token");
        Long id = Long.valueOf(userid.toString());
        immigrationServicesDto.setUserId(id);
        return service.insert(immigrationServicesDto);
    }
    //普通用户查询自己的咨询表
    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/user")
    public Result selectByUser(@RequestHeader("Authorization")String token){
        //获取请求头里的userid
        String substring = token.substring(7);
        Claims claims = JwtUtils.parseJWT(substring);
        Object userid = claims.get("Token");
        Long id = Long.valueOf(userid.toString());
        return service.selectByUser(id);
    }
    //律师查询咨询自己的咨询表
    @PreAuthorize("hasAnyAuthority('IMMIGRATION_LAWYER')")
    @GetMapping("/immigration")
    public Result selectById(@RequestHeader("Authorization")String token){
        //获取请求头里的userid
        String substring = token.substring(7);
        Claims claims = JwtUtils.parseJWT(substring);
        Object userid = claims.get("Token");
        Long id = Long.valueOf(userid.toString());
        return service.selectByImmigration(id);
    }
    //律师根据咨询表ID修改咨询表
    @PreAuthorize("hasAnyAuthority('IMMIGRATION_LAWYER')")
    @PutMapping("/immigration")
    public Result updateByUser(@RequestBody ImmigrationDto immigrationDto){
        return service.updateByUser(immigrationDto);
    }
    //超级管理员删除咨询表
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @DeleteMapping("/id/{id}")
    public Result deleteById(@PathVariable("id") long id){
        return service.deleteById(id);
    }
}
