package com.sample.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/myresource")
public class MyResource {
	
	@Autowired
	SpringInfo info;

	@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
		String result = null;
		try{
			result = info.getName("Spring is working");
		} catch(Exception e){
			e.printStackTrace();
		}
        return result;
    }
	
	@Path("name")
	@Produces(MediaType.TEXT_PLAIN)
	public MyResource name(){
		return this;
	}
	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String getName(){
//		return info.getName("Spring is working");
//	}

}
