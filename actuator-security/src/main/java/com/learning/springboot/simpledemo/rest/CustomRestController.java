package com.learning.springboot.simpledemo.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomRestController {
	
	@Value("${coach.name}")
	String coachName;
	
	@Value("${team.name}")
	String teamName;
	
	@GetMapping("/teaminfo")
	public String getTeamInfo()
	{
		return "Coach: " + coachName + " Team: " + teamName;
	}
	
	@GetMapping("/")
	public String sayHello()
	{
		return "Say Hello! Local time is " + LocalDateTime.now();
	}

}
