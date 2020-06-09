package com.learning.microservices.hystrix.moviecatalog.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.microservices.hystrix.moviecatalog.model.CatalogItem;
import com.learning.microservices.hystrix.moviecatalog.model.UserRatings;
import com.learning.microservices.hystrix.moviecatalog.service.MovieInfoService;
import com.learning.microservices.hystrix.moviecatalog.service.MovieRatingService;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	@Autowired
	MovieRatingService ratingService;
	
	@Autowired
	MovieInfoService infoService;

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
	{
		UserRatings userRatings = ratingService.getRatings(userId);
		
		return userRatings.getRatings().stream().map(rating -> infoService.getCatalogItem(rating))
												.collect(Collectors.toList());

	}
}
