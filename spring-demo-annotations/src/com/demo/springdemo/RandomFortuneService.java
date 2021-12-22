package com.demo.springdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {

	// Create an array of Strings
	 private ArrayList<String> mFortunes = new ArrayList<String>();
	 private Random mRandom = new Random();
	
	 @PostConstruct
		public void doMyStartupStuff() {
			System.out.println(">> RandomFortuneService: inside of doMyStartupStuff()");
			try {
				String lString=""; 
				@SuppressWarnings("resource")
				BufferedReader lBufferedReader = new BufferedReader(new FileReader(".\\src\\com\\demo\\springdemo\\myFile"));
				 while ((lString = lBufferedReader.readLine()) != null) 
				 {
					 mFortunes.add(lString);
				 } 
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
		
		// Define destroy method
		@PreDestroy
		public void doMyCleanupStuff() {
			System.out.println(">> RandomFortuneService: inside of doMyCleanupStuff()");
		}
		
	@Override
	public String getFortune() {
		
		// Pick a random string from the array
		int lIndex = mRandom.nextInt(mFortunes.size());
		return mFortunes.get(lIndex);
	}
}
