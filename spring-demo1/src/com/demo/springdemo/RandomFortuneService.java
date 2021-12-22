package com.demo.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {

	private String[] mRandomFortune = {"good", "bad", "medium"};
	private Random mRandom = new Random();
	
	@Override
	public String getFortune() {
		int lIndex = mRandom.nextInt(mRandomFortune.length);
		return mRandomFortune[lIndex];
	}
}
