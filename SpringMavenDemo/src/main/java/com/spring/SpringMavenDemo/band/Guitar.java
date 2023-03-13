package com.spring.SpringMavenDemo.band;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class Guitar implements Instrument {

	@Override
	public void play() {
		System.out.println("Playing guitar");
		
	}

}
