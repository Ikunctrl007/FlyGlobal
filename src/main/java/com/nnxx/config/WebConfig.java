package com.nnxx.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 标记这是一个配置类
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 添加一个资源处理器，用于处理指定路径下的资源
        registry.addResourceHandler("/upload/**")
                // 指定资源的实际位置，这里是文件系统中的 upload 文件夹
                .addResourceLocations("file:upload/");
    }
}
