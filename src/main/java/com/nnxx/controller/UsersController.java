package com.nnxx.controller;


import com.nnxx.domain.Result;
import com.nnxx.domain.dto.PagesDto;
import com.nnxx.domain.dto.UsersDto;
import com.nnxx.domain.po.Users;
import com.nnxx.service.IUsersService;
import com.nnxx.util.JwtUtils;
import com.nnxx.util.ParseTokenUtils;
import io.jsonwebtoken.Claims;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author 宁x
 * @since 2024-10-23
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final IUsersService service;
    //注册接口
    @PostMapping("/register")
    public Result register(@RequestBody UsersDto usersDto){
        return service.insert(usersDto);
    }
    //管理员分页查询所有用户信息
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @GetMapping("/admin/page")
    public Result selectAll(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(required = false) boolean isAsc) {
        // 构造 PagesDto 对象
        PagesDto pagesDto = new PagesDto();
        pagesDto.setPage(page);
        pagesDto.setSize(size);
        pagesDto.setSortBy(sortBy);
        pagesDto.setAsc(isAsc);

        // 调用服务层的方法
        return service.selectAll(pagesDto);
    }

    /**
     * 查询所有的用户的用户名和头像
     * @return
     */
    @GetMapping("/info/{id}")
    public Result selectInfo(@PathVariable Long id){
        return service.selectInfo(id);
    }

    //普通用户查询个人信息
    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping()
    public Result selectOne(@RequestHeader("Authorization") String token){
        //首先获取请求头里的Token，在取出Token里的userid
        Long id = ParseTokenUtils.parseToken(token);
        return service.selectOne(id);
    }
    //普通用户查询个人信息
    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/id/{id}")
    public Result selectById(@PathVariable("id")Long userid){
        return service.selectOne(userid);
    }
    //普通用户修改个人信息
    @PreAuthorize("hasAnyAuthority('USER')")
    @PutMapping()
    public Result updateOne(@RequestHeader("Authorization") String token,@RequestBody UsersDto usersDto){
        //首先获取请求头里的Token，在取出Token里的userid
        Long id = ParseTokenUtils.parseToken(token);
        return service.updateOne(id,usersDto);
    }
    //超级管理员任意修改人员信息
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @PutMapping("/admin")
    public Result updateById(@RequestBody Users users){
        return service.updateAdmin(users);
    }
    //超级管理员可以删除人员
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    @DeleteMapping("/admin/{id}")
    public Result deleteById(@PathVariable int id){
        return service.deleteId(id);
    }
    //超级管理员根据角色分类查询用户
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR','FWFWQEF')")
    @GetMapping("/admin/role/{roleType}")
    public Result selectByRoleType(@PathVariable int roleType){
        return service.selectByRoleType(roleType);
    }
    @PostMapping("/admin")
    @PreAuthorize("hasAnyAuthority('SUPER_ADMINISTRATOR')")
    public Result insert(@RequestBody Users users){
        return service.insertUser(users);
    }
}
