package com.demo.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.demo.springdemo")
@PropertySource("classpath:sport.properties")
public class SportConfig {

	// Define bean for our sad fortune service
	// The method name will be the bean id
	@Bean 
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	
	//define bean for swimCoach and inject dependency
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
