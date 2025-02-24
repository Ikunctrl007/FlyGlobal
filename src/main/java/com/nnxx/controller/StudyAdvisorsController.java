package com.nnxx.controller;


import com.nnxx.domain.Result;
import com.nnxx.domain.po.StudyAdvisors;
import com.nnxx.service.IStudyAdvisorsService;
import com.nnxx.util.JwtUtils;
import com.nnxx.util.ParseTokenUtils;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 留学顾问表 前端控制器
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@RestController
@RequestMapping("/study-advisors")
@RequiredArgsConstructor
@PreAuthorize("hasAnyAuthority('STUDY_ABROAD_CONSULTANT')")
public class StudyAdvisorsController {
    private final IStudyAdvisorsService service;
    @PostMapping
    public Result insert(@RequestBody StudyAdvisors studyAdvisors,@RequestHeader("Authorization") String token){
        Long id = ParseTokenUtils.parseToken(token);
        studyAdvisors.setUserId(id);
        return service.insertOne(studyAdvisors);
    }

    @PutMapping
    public Result update(@RequestBody StudyAdvisors studyAdvisors ){
        return service.updateOne(studyAdvisors);
    }

    @DeleteMapping("/admin/id/{id}")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    //超级管理员删除顾问
    public Result delete(@PathVariable("id") Integer id){
        return service.delete(id);
    }

    @GetMapping
    public Result selectOne(@RequestHeader("Authorization") String token){
        Long id = ParseTokenUtils.parseToken(token);
        return service.selectOne(id);
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    //超级管理员可以查看所有的留学顾问
    public Result selectAll(){
        return service.selectAll();
    }

}
