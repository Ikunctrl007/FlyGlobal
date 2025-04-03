package com.nnxx.service.impl;

import com.nnxx.domain.Code;
import com.nnxx.domain.LoginUser;
import com.nnxx.domain.Result;
import com.nnxx.domain.po.Users;
import com.nnxx.domain.vo.LoginResponse;
import com.nnxx.domain.vo.UsersVo;
import com.nnxx.exception.BusinessException;
import com.nnxx.service.IUsersService;
import com.nnxx.service.LoginService;
import com.nnxx.util.JwtUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private IUsersService service;
    @SneakyThrows
    @Override
    public Result login(Users user) {
        //AuthenticationManager authenticationManager进行用户验证
        //获取用户名与密码，并封装成authenticationManager对象里
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        //使用Authentication类接收该对象
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //判断该类中对象是否为空，若为空则代表用户名或密码错误，给出提示
        if(Objects.isNull(authenticate)){
            throw new BusinessException(Code.SELECT_ERROR,"用户名或密码错误");
        }
        //认证通过后使用userid生成一个jwt，并存入redis中
        //首先获取Authentication对象中的用户ID
        LoginUser loginUser= (LoginUser) authenticate.getPrincipal();
        Long userid = loginUser.getUser().getId();
//        使用userid生成一个jwt的token
        Map<String, Object> claims=new HashMap<>();
        //添加权限
        claims.put("authorities", loginUser.getPermissions());
        claims.put("Token",userid);
        String jwt = JwtUtils.generateJwt(claims);
        //通过获取userid查询用户信息
        Result result = service.selectOne(userid);
        UsersVo data = (UsersVo) result.getData();
        return new Result(200,"登录成功",new LoginResponse(jwt,data.getName(),userid,Long.valueOf(data.getRoleId().getStatus()),data.getAvatar()));
    }

}
