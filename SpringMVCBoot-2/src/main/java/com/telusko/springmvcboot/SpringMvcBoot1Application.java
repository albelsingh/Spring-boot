package com.telusko.springmvcboot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMvcBoot1Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringMvcBoot1Application.class, args);
		openHomePage();
		
		
		
	}
	private static void openHomePage() throws IOException {
	       Runtime rt = Runtime.getRuntime();
	       rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://localhost:8083");
	    }

}
