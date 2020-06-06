package com.learning.microservices.moviecatalog.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.learning.microservices.moviecatalog.model.CatalogItem;
import com.learning.microservices.moviecatalog.model.Movie;
import com.learning.microservices.moviecatalog.model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class CatalogResource {
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId)
	{
		UserRatings userRatings = restTemplate.getForObject("http://movie-ratings-service/ratingsdata/users/" + userId, UserRatings.class);
		
		return userRatings.getRatings().stream().map(rating -> {
			Movie theMovie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
			return new CatalogItem(theMovie.getName(), "A non-fictional drama", rating.getRating());
		}
		).collect(Collectors.toList());

	}
}
