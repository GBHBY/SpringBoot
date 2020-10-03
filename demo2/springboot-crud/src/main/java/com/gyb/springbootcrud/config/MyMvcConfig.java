package com.gyb.springbootcrud.config;

import com.gyb.springbootcrud.component.MyLocaleResolver;
import com.gyb.springbootcrud.controller.LoginHandlerInterceptor;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @Author gb
 * @Date 2020/9/26 14:38
 * @Version 1.0
 * description:
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/user/login", "/webjars/**","/asserts/**");
    }



    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("addViewControllers");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");

    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();

    }
}

