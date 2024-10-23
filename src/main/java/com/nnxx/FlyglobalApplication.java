package com.nnxx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.nnxx.mapper")
public class FlyglobalApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlyglobalApplication.class, args);
    }

}
