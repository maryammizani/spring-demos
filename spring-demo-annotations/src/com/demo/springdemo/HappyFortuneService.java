package com.demo.springdemo;

import org.springframework.stereotype.Component;

@Component   // Spring will scan our package and register all Components
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day";
	}

}
