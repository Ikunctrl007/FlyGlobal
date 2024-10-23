package com.nong.config;

import com.nong.exception.AccessDeniedHandlerException;
import com.nong.exception.AuthenticationEntryPointException;
import com.nong.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration // 声明这是一个配置类
@EnableWebSecurity // 启用Web安全配置
@EnableGlobalMethodSecurity(prePostEnabled = true) // 启用全局方法安全配置，开启@PreAuthorize和@PostAuthorize注解的支持
public class SecurityConfig  {

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter; // 注入JwtAuthenticationTokenFilter
    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint; // 注入AuthenticationEntryPoint
    @Autowired
    private AccessDeniedHandlerException handlerException; // 注入AccessDeniedHandlerException

    @Bean // 声明一个Bean，用于提供PasswordEncoder实例
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // 返回BCryptPasswordEncoder实例
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)// 禁用CSRF保护
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.GET, "/products").permitAll() // 允许匿名访问GET /products
                        .requestMatchers("/login", "/register", "/upload/**", "/orders/update").permitAll()
                        .anyRequest().authenticated())
                .exceptionHandling(config -> config
                        .authenticationEntryPoint(authenticationEntryPoint)// 配置认证入口点
                        .accessDeniedHandler(handlerException))// 配置访问被拒绝处理器
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

        http.cors();
        return http.build();
    }

    @Bean // 声明一个Bean，用于提供AuthenticationManager实例
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager(); // 返回AuthenticationManager实例
    }
}
