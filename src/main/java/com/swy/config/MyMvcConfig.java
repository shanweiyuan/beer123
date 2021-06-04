package com.swy.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("show");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/dashboard.html").setViewName("dashboard");
        registry.addViewController("/register.html").setViewName("register");
        registry.addViewController("/SendEmail.html").setViewName("SendEmail");
        registry.addViewController("/forgot-password.html").setViewName("forgot-password");
        registry.addViewController("/show.html").setViewName("show");
        registry.addViewController("/tables.html").setViewName("tables");
        registry.addViewController("/charts.html").setViewName("charts");

    }
}
