package com.nnxx.filter;

import com.alibaba.fastjson.JSONObject;
import com.nnxx.domain.Code;
import com.nnxx.domain.LoginUser;
import com.nnxx.domain.po.Users;
import com.nnxx.exception.BusinessException;
import com.nnxx.service.IUsersService;
import com.nnxx.util.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private IUsersService usersService;
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
        List<String> authorities;
        long id;
        try {
            Claims claims = JwtUtils.parseJWT(token);
            // 安全转换
            Object userid = claims.get("Token");
            //获取权限集合
            authorities = (List<String>) claims.get("authorities");
            id = Long.parseLong(userid.toString());
        } catch (Exception e) {
            throw new BusinessException(Code.SELECT_ERROR,"Token非法");
        }
        //通过userid查询数据库是否有数据，有数据代表注册过了
        Users users = usersService.getById(id);
        if(Objects.isNull(users)){
            throw new BusinessException(Code.SELECT_ERROR,"账号异常");
        }

        LoginUser loginUser = new LoginUser();
        loginUser.setUser(users);
        loginUser.setPermissions(authorities);
        //若拿到了用户信息，则取出用户名密码，将齐封装成SecurityContextHolder对象中
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser,null,loginUser.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //最终放行
        filterChain.doFilter(request,response);

    }
}
