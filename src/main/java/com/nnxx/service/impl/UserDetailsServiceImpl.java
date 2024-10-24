package com.nnxx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.nnxx.domain.Code;
import com.nnxx.domain.LoginUser;
import com.nnxx.domain.enums.UsersRole;
import com.nnxx.domain.po.Users;
import com.nnxx.exception.BusinessException;
import com.nnxx.mapper.UsersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 用户详情服务实现类，用于 Spring Security 用户身份认证和授权。
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersMapper userMapper;

    /**
     * 通过用户名加载用户详情。
     * @param username 用户名
     * @return UserDetails 用户详情
     * @throws UsernameNotFoundException 如果未找到用户
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 创建一个查询条件 LambdaQueryWrapper 对象，用于查询指定用户名的用户信息
        LambdaQueryWrapper<Users> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Users::getUsername, username);

        // 查询数据库，获取指定用户名的用户信息
        Users user = userMapper.selectOne(lambdaQueryWrapper);

        // 如果用户信息为空，抛出用户名或密码错误的业务异常
        if (Objects.isNull(user)) {
            throw new BusinessException(Code.SELECT_ERROR, "用户名不存在");
        }

        //TODO 添加权限信息
        // 模拟为用户添加权限信息，这里使用一个固定的权限列表作为示例
        UsersRole usersRole = user.getRole();
        List<String> authorities = new ArrayList<>();
        authorities.add("USER");
        //判断是否是管理员
        if(usersRole==UsersRole.IMMIGRATION_LAWYER){
            authorities.add("IMMIGRATION_LAWYER");
        } else if (usersRole==UsersRole.STUDY_ABROAD_CONSULTANT) {
            authorities.add("STUDY_ABROAD_CONSULTANT");
        }else if(usersRole==UsersRole.VISA_OFFICER){
            authorities.add(("VISA_OFFICER"));
        }else if (usersRole==UsersRole.SUPER_ADMINISTRATOR){
            authorities.add("STUDY_ABROAD_CONSULTANT");
            authorities.add(("VISA_OFFICER"));
            authorities.add("IMMIGRATION_LAWYER");
            authorities.add("SUPER_ADMINISTRATOR");
        }
        // 返回一个自定义的 UserDetails 实现类 LoginUser，将查询到的用户信息和权限列表传入构造函数
        return new LoginUser(user, authorities);
    }
}
