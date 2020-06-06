package com.learning.microservices.movieinfo.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.microservices.movieinfo.model.Movie;

@RestController
@RequestMapping("/movies")
public class InfoResource {

	@GetMapping("/{movieId}")
	public Movie getMovie(@PathVariable("movieId") String movieId)
	{
		return new Movie(movieId, "Test name");
	}
}
