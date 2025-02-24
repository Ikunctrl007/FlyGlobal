package com.nnxx.controller;


import com.nnxx.domain.Result;
import com.nnxx.domain.dto.ApplicationConsultantDto;
import com.nnxx.domain.dto.ApplicationsDto;
import com.nnxx.domain.po.Applications;
import com.nnxx.service.IApplicationsService;
import com.nnxx.util.JwtUtils;
import com.nnxx.util.ParseTokenUtils;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 申请信息表 前端控制器
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@RestController
@RequestMapping("/applications")
@RequiredArgsConstructor
public class ApplicationsController {
    private final IApplicationsService service;
    //普通用户发起申请
    @PreAuthorize("hasAnyAuthority('USER')")
    @PostMapping
    public Result insert(@RequestHeader("Authorization") String token,@RequestBody ApplicationsDto applicationsDto){
        //取出Token里的userid复制给Dto
        Long id = ParseTokenUtils.parseToken(token);
        applicationsDto.setUserId(id);
        return service.insert(applicationsDto);
    }
    //普通用户根据申请状态查询申请
    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/status/{id}")
    public Result selectOne(@RequestHeader("Authorization")String token,@PathVariable int id){
        Long userid = ParseTokenUtils.parseToken(token);
        return service.selectOne(userid,id);
    }
    //留学顾问修改申请
    @PreAuthorize("hasAnyAuthority('STUDY_ABROAD_CONSULTANT')")
    @PutMapping
    public Result updateOne(@RequestBody ApplicationConsultantDto applicationConsultantDto){
        return service.updateOne(applicationConsultantDto);
    }
    //留学顾问根据申请状态查询申请
    @PreAuthorize("hasAnyAuthority('STUDY_ABROAD_CONSULTANT')")
    @GetMapping("/advisors/{status}")
    public Result selectAll(@PathVariable int status){
        return service.selectAll(status);
    }

    //留学顾问查询自己的申请
    @PreAuthorize("hasAnyAuthority('STUDY_ABROAD_CONSULTANT')")
    @GetMapping("/list")
    public Result selectByAdvisors(@RequestHeader("Authorization")String token){
        Long userid = ParseTokenUtils.parseToken(token);
        return service.selectByAdvisors(userid);
    }

    //管理员查询所有的申请表
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @GetMapping("/admin")
    public Result selectAllApplication(){
        return service.selectAllApplication();
    }
    //管理员修改申请表
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @PutMapping("/admin")
    public Result updateApplication(@RequestBody Applications applications){
        return service.updateApplication(applications);
    }
    //管理员添加申请表
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @PostMapping("/admin")
    public Result insertApplication(@RequestBody Applications applications){
        return service.insertApplication(applications);
    }
    //管理员删除申请表
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @DeleteMapping("/admin/id/{id}")
    public Result updateApplication(@PathVariable("id") Long id){
        return service.deleteById(id);
    }
}
