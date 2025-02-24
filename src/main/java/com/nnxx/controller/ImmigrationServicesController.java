package com.nnxx.controller;


import com.nnxx.domain.Result;
import com.nnxx.domain.dto.ImmigrationDto;
import com.nnxx.domain.dto.ImmigrationServicesDto;
import com.nnxx.domain.po.Applications;
import com.nnxx.domain.po.ImmigrationServices;
import com.nnxx.service.IImmigrationServicesService;
import com.nnxx.util.JwtUtils;
import com.nnxx.util.ParseTokenUtils;
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
        Long id = ParseTokenUtils.parseToken(token);
        immigrationServicesDto.setUserId(id);
        return service.insert(immigrationServicesDto);
    }
    //普通用户查询自己的咨询表
    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/user")
    public Result selectByUser(@RequestHeader("Authorization")String token){
        //获取请求头里的userid
        Long id = ParseTokenUtils.parseToken(token);
        return service.selectByUser(id);
    }
    //律师查询咨询自己的咨询表
    @PreAuthorize("hasAnyAuthority('IMMIGRATION_LAWYER')")
    @GetMapping("/list")
    public Result selectById(@RequestHeader("Authorization")String token){
        //获取请求头里的userid
        Long id = ParseTokenUtils.parseToken(token);
        return service.selectByImmigration(id);
    }
    //律师根据咨询表ID修改咨询表
    @PreAuthorize("hasAnyAuthority('IMMIGRATION_LAWYER')")
    @PutMapping("/immigration")
    public Result updateByUser(@RequestBody ImmigrationDto immigrationDto){
        return service.updateByUser(immigrationDto);
    }
    //管理员查询所有的申请表
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @GetMapping("/admin")
    public Result selectAllApplication(){
        return service.selectAllImmigration();
    }
    //管理员修改申请表
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @PutMapping("/admin")
    public Result updateApplication(@RequestBody ImmigrationServices immigrationServices){
        return service.updateImmigration(immigrationServices);
    }
    //管理员添加申请表
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @PostMapping("/admin")
    public Result insertApplication(@RequestBody ImmigrationServices immigrationServices){
        return service.insertImmigration(immigrationServices);
    }
    //超级管理员删除咨询表
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @DeleteMapping("/admin/id/{id}")
    public Result deleteById(@PathVariable("id") long id){
        return service.deleteById(id);
    }
}
