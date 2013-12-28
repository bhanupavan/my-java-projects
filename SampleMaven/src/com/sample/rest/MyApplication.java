package com.sample.rest;

import org.glassfish.jersey.server.ResourceConfig;

public class MyApplication extends ResourceConfig{
	
	
	
	public MyApplication () {
		packages("com.sample.rest");
    }

}
