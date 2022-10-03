package com.msh.springboot.config;

import com.msh.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//攔截器的註冊
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         * new LoginInterceptor() 設置的攔截器
         * "/**"攔截的範圍
         * excludePathPatterns() 範圍內不攔截的資源
         */
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/","/login","images/**","/upload.html","/upload");
    }
}
