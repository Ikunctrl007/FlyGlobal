package com.nnxx;

import com.nnxx.util.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class FlyglobalApplicationTests {

    @Test
    void contextLoads() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode("123456");
        System.out.println(bCryptPasswordEncoder.matches("","$2a$10$yl0Z34nNwlYGr5jvDtaQXuraftop41bgAlUKDcE/wnNQVZ6PXC0.y"));
//        System.out.println(JwtUtils.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJUb2tlbiI6MSwiZXhwIjoxNzM0MDEyMjAyfQ.EgkjiQGr_yTxp4idkONJxkVy1BwSo2cwFqjlqOxkEt4"));
    }

}
