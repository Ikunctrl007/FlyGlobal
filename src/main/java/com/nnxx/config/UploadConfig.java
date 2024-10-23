package com.nong.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File; // 导入File类

@Configuration
public class UploadConfig {

    @Bean // 声明一个Bean
    public CommandLineRunner init() { // 声明一个返回CommandLineRunner类型的方法
        return new CommandLineRunner() { // 创建一个匿名内部类实现CommandLineRunner接口
            @Override // 重写父类方法
            public void run(String... args) throws Exception {
                File uploadDir = new File("upload"); // 创建一个名为upload的文件对象
                if (!uploadDir.exists()) { // 检查upload目录是否存在
                    uploadDir.mkdir(); // 如果upload目录不存在，则创建该目录
                }
            }
        };
    }
}
