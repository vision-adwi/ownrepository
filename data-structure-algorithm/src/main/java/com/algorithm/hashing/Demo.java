package com.algorithm.hashing;

public class Demo {

	public static void main(String[] args) {
		String trainingData = "This post is not about Spark, Storm or Samza. It's about a data structure which "
				+ "is one of the relatively new entrants in the domain of stream processing, which is simple to "
				+ "implement, but has already proved to be of immense use in serving a certain class of queries "
				+ "over huge streams of data. I have been doing some readings about the application of such structures "
				+ "and thought of sharing them with the readers of my blog.";
		
		MinCountSketch minCountSketch = new MinCountSketch();
		for(byte ch:trainingData.getBytes()) {
			minCountSketch.train(ch);
		}
		System.out.println("Training done....");
		minCountSketch.show();
		System.out.println("Occurence of T: " +minCountSketch.occurence((byte)',') );

	}

}
