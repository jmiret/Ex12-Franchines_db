package com.franchines;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.franchines.FranchinesApplication;

@SpringBootApplication
public class FranchinesApplication {

	public static void main(String[] args) {
		// Customize Tomcat server port 
				SpringApplication app = new SpringApplication(FranchinesApplication.class);
		        app.setDefaultProperties(Collections
		          .singletonMap("server.port", "8081"));
		        app.run(args);	
	}

}
