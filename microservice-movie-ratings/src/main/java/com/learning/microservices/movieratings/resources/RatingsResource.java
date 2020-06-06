package com.learning.microservices.movieratings.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.microservices.movieratings.model.Rating;
import com.learning.microservices.movieratings.model.UserRatings;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

	@GetMapping("/{movieId}")
	public Rating getMovieRating(@PathVariable("movieId") String movieId)
	{
		return new Rating(movieId, 3);
	}
	
	@GetMapping("/users/{userId}")
	public UserRatings getUserRatings(@PathVariable("userId") String userId)
	{
		List<Rating> ratings = Arrays.asList(new Rating[]{
				new Rating("sk4", 5),
				new Rating("pk9", 2)});
		
		return new UserRatings(ratings);
	}

}
