package com.springsecurity.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.springsecurity.demo")
public class DemoAppConfig {
	
	// Define a bean for ViewResolver
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver lViewResolver = new InternalResourceViewResolver();
		lViewResolver.setPrefix("/WEB-INF/view/");
		lViewResolver.setSuffix(".jsp");
		return lViewResolver;
	}
}
