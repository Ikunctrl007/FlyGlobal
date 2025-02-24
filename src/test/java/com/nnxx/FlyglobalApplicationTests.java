package com.nnxx;

import com.nnxx.service.IImmigrationLawyersService;
import com.nnxx.service.IStudyAdvisorsService;
import com.nnxx.service.IVisaOfficersService;
import com.nnxx.util.JwtUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class FlyglobalApplicationTests {
@Autowired
private IVisaOfficersService service;
    @Test
    void contextLoads() {
        System.out.println(service.selectOne(7L));
    }

}
