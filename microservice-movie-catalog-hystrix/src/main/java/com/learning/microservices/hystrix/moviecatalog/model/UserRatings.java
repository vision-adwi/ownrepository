package com.learning.microservices.hystrix.moviecatalog.model;

import java.util.List;

public class UserRatings {
	List<Rating> ratings;
	
	public UserRatings() {
	}
	
	public UserRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

}
