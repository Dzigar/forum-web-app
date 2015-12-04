package com.forum.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class ForumWebApp extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(ForumWebApp.class, args);
	}
}
