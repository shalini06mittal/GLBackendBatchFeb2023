package com.spring.SpringMavenDemo.band;

import org.springframework.stereotype.Component;

@Component
public class Violin implements Instrument {

	@Override
	public void play() {
		System.out.println("Playing violin");
		
	}

}
