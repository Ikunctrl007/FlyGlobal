package com.nnxx.controller;


import com.nnxx.domain.Result;
import com.nnxx.domain.dto.ApplicationConsultantDto;
import com.nnxx.domain.dto.ApplicationsDto;
import com.nnxx.domain.po.Applications;
import com.nnxx.service.IApplicationsService;
import com.nnxx.util.JwtUtils;
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
        String substring = token.substring(7);
        Claims claims = JwtUtils.parseJWT(substring);
        Long id = Long.valueOf(claims.get("Token").toString());
        applicationsDto.setUserId(id);
        return service.insert(applicationsDto);
    }
    //普通用户根据申请状态查询申请
    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/status/{id}")
    public Result selectOne(@RequestHeader("Authorization")String token,@PathVariable int id){
        String substring = token.substring(7);
        Claims claims = JwtUtils.parseJWT(substring);
        Long userid = Long.valueOf(claims.get("Token").toString());
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
    @GetMapping("/list/{id}")
    public Result selectAll(@PathVariable int id){
        return service.selectAll(id);
    }

}
