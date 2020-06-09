package com.learning.microservices.hystrix.moviecatalog.service;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learning.microservices.hystrix.moviecatalog.model.Rating;
import com.learning.microservices.hystrix.moviecatalog.model.UserRatings;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieRatingService {
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod= "getRatingsFallback",
			commandProperties= {
					@HystrixProperty(name="", value="")
			})
	public UserRatings getRatings(String userId){
		UserRatings userRatings = restTemplate.getForObject("http://movie-ratings-service/ratingsdata/users/" + userId, UserRatings.class);
		return userRatings;
	}
	
	public UserRatings getRatingsFallback(String userId) {
		UserRatings userRatings = new UserRatings(Arrays.asList(
				new Rating("No movie", 0)));
		return userRatings;
	}

}
