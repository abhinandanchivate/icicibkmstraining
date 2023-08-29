package com.icicibk.empms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration // this class is a configuration class.

@ComponentScan(basePackages = "com.icicibk.empms")

@PropertySource( "classpath:application.properties")
public class AppConfig {
	@Autowired
	Environment env; // it will get the object implicitly via DI.
	public AppConfig() {
		// TODO Auto-generated constructor stub
		System.out.println("config called");
	}

}
