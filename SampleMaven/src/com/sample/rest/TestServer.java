package com.sample.rest;

import java.net.URI;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.grizzly.servlet.WebappContext;
import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.hk2.api.ServiceLocatorFactory;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpContainer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ApplicationHandler;
import org.glassfish.jersey.server.ContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.model.Resource;
import org.glassfish.jersey.server.spi.ComponentProvider;
import org.glassfish.jersey.server.spring.SpringComponentProvider;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

public class TestServer {
	
	
	public static void springSetup(){
		System.setProperty("spring.profiles.active", "dev");
		GenericXmlApplicationContext tx =  new GenericXmlApplicationContext("applicationContext.xml");
	}
	
	
	public static void server(){
		// springSetup();
		URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
		
//		GrizzlyHttpContainer handler = ContainerFactory.createContainer(GrizzlyHttpContainer.class, new MyApplication());
//	    HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri,handler,false,null,false);
	    
		ApplicationHandler applicationHandler = new ApplicationHandler(new MyApplication());
	    HttpServer server = GrizzlyHttpServerFactory.createHttpServer(baseUri, applicationHandler, false);
	    WebappContext ctx = new WebappContext("myApp", "/WEB-INF/web.xml");
	    ctx.deploy(server);
	    
	    try{
	    	server.start();
	    	System.in.read();
	    } catch(Exception e){
	    	e.printStackTrace();
	    }
	}
	
	public static void main(String...strings){
		server();
	}

}
