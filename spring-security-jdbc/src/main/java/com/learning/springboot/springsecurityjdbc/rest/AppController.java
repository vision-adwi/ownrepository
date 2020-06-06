package com.learning.springboot.springsecurityjdbc.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
	
	@GetMapping("/")
	public String rootUri() {
		return "<h1>Welcome</h1>"+"\n<h2>Admin Area</h2>"+"\n<h2>User Area</h2>";
	}
	
	@GetMapping("/admin")
	public String adminUri() {
		return "<h2>Admin Area</h2>";
	}
	
	@GetMapping("/user")
	public String userUri() {
		return "<h3>User Area</h3>";
	}

}
