package com.gl.boot.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Endpoint(id = "techgatha")
public class MyEndPoint {

	@ReadOperation
	public MyEndPointResponse features()
	{
		MyEndPointResponse response;
		
		return new MyEndPointResponse(1,"techgatha endpoint","Active");
	}
}
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class MyEndPointResponse
{
	private int id;
	private String name;
	private String status;	
}


