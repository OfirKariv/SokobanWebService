package com.sokoban.SokobanWS;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("hello")
public class HelloWorldService {
	@GET
	public String getMessage() {
		return "Hello World!!";
	}
	
	
}