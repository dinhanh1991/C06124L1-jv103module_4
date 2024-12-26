package com.example.customers.config;

import com.example.customers.service.CustomerService;
import com.example.customers.service.ICustomerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.example.customers.controller")
public class AppConfiguration implements WebMvcConfigurer {
    @Bean
    public ViewResolver corsConfigurer() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/templates/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
    @Bean
    public ICustomerService customerService() {
        return new CustomerService();
    }
}
