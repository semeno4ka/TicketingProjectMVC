package com.cydeo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override// Shortcut for getmapping
    public void addViewControllers(ViewControllerRegistry registry) {// override viewController
        registry.addViewController("/welcome").setViewName("welcome");// static pages not requesting any data
        registry.addViewController("/login").setViewName("login");// for view only, no model to pass
        registry.addViewController("/").setViewName("login");

    }

}
