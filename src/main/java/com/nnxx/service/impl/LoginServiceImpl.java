package com.nong.service.impl;

import com.nong.domain.Code;
import com.nong.domain.LoginUser;
import com.nong.domain.Result;
import com.nong.domain.UserInformation;
import com.nong.exception.BusinessException;
import com.nong.service.LoginService;
import com.nong.util.JwtUtils;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @SneakyThrows
    @Override
    public Result login(UserInformation user) {
        //AuthenticationManager authenticationmanager进行用户验证
        //获取用户名与密码，并封装成authenticatinomanager对象里
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
        String userid = loginUser.getUser().getId().toString();
//        使用userid生成一个jwt的token
        Map<String, Object> claims=new HashMap<>();
        claims.put("Token",userid);
        String jwt = JwtUtils.generateJwt(claims);
        Map<String,String> jj = new HashMap<>();
        jj.put("Token",jwt);
        //将用户所携带的信息存入redis中
            redisTemplate.opsForValue().set("Login:"+userid,loginUser);


        return new Result(200,"登录成功",jj);
    }

    @Override
    public Result logout() {
        //退出登录，只需删除redis存入的用户信息即可
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser logout = (LoginUser) authentication.getPrincipal();
        String userid = logout.getUser().getId().toString();
        redisTemplate.delete("Login:" + userid);
        return new Result(200,"退出成功",null);
    }
}
