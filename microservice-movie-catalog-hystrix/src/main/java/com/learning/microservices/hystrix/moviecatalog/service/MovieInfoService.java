package com.learning.microservices.hystrix.moviecatalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.learning.microservices.hystrix.moviecatalog.model.CatalogItem;
import com.learning.microservices.hystrix.moviecatalog.model.Movie;
import com.learning.microservices.hystrix.moviecatalog.model.Rating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class MovieInfoService {
	@Autowired
	RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "getCatalogItemFallback",
	    commandProperties = {
	        @HystrixProperty(name = "execution.isolation.strategy", value="SEMAPHORE"),
	        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
	        @HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "500"),
	        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value="60"),
	        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
	        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "5000")
	    }
	)
	public CatalogItem getCatalogItem(Rating rating){
		Movie theMovie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
		return new CatalogItem(theMovie.getName(), "A non-fictional drama", rating.getRating());
	}
	
	public CatalogItem getCatalogItemFallback(Rating rating){
		return new CatalogItem("No name", "A non-fictional drama", rating.getRating());
	}

}
