package com.nnxx.controller;


import com.nnxx.domain.Result;
import com.nnxx.domain.po.Universities;
import com.nnxx.service.IUniversitiesService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 院校信息表 前端控制器
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 * 1. 用户可以查询所有的院校信息
 * 2. 用户可以根据院校名称查询院校信息
 * 3. 管理员可以增删改院校信息
 */
@RestController
@RequestMapping("/universities")
@PreAuthorize("hasAnyAuthority('USER')")
public class UniversitiesController {
    @Autowired
    private IUniversitiesService service;
    // 用户查询所有的院校信息
    @GetMapping("/list")
    public Result selectAll(){
        return service.selectAll();
    }
    //用户根据院校名称查询院校信息
    @GetMapping("/search")
    public Result selectByName(@RequestParam("collegeName") String collegeName){
        return service.selectByName(collegeName);
    }
    //管理员添加院校信息
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @PostMapping
    public Result insert(@RequestBody Universities universities){
        return  service.insert(universities);
    }
    //管理员修改院校信息
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @PutMapping
    public Result updateByCollegeId(@RequestBody Universities universities){
        return  service.updateByCollegeId(universities);
    }
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @DeleteMapping("/id/{id}")
    public Result deleteById(@PathVariable("id") Long id){
        return service.deleteById(id);
    }
}
