package com.nong.filter;

import com.alibaba.fastjson.JSONObject;
import com.nong.domain.Code;
import com.nong.domain.LoginUser;
import com.nong.exception.BusinessException;
import com.nong.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private RedisTemplate<Object,Object> redisTemplate;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //首先要获取Token
        String BearerToken = request.getHeader("Authorization");
        //若请求头为空则直接放行
        if(!StringUtils.hasText(BearerToken)){
            filterChain.doFilter(request,response);
            //一定要return
            return;
        }
        String token = BearerToken.substring(7);

        //若不为空则解析Token
        Object userid;
        try {
            Claims claims = JwtUtils.parseJWT(token);
            userid = claims.get("Token");
        } catch (Exception e) {
            throw new BusinessException(Code.SELECT_ERROR,"Token非法");
        }
        //通过userid去redis中取出用户信息
        String login = "Login:"+userid;
        // 先转成JSON对象
        JSONObject jsonObject = (JSONObject) redisTemplate.opsForValue().get(login);
        // JSON对象转换成Java对象
        if (Objects.isNull(jsonObject)){
            throw new BusinessException(Code.SELECT_ERROR,"用户未登录");
        }
        LoginUser loginUser = jsonObject.toJavaObject(LoginUser.class);
        //若拿到了用户信息，则取出用户名密码，将齐封装成SecurityContextHolder对象中
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //最终放行
        filterChain.doFilter(request,response);

    }
}
