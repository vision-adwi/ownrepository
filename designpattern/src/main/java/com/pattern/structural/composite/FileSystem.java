package com.pattern.structural.composite;

/*
Compose objects into tree structures to represent whole-part hierarchies. 
Composite lets clients treat individual objects and compositions of objects uniformly.
*/
public class FileSystem {

	public static void main(String[] args) {
		File cGif = new AbsoluteFile("c.gif");
		File custOver = new AbsoluteFile("customer_override.properties");
		File jdbcProps = new AbsoluteFile("jdbc.properties");

		File webApp = new Directory("webapp");
		File conf = new Directory("config");
		File webInf = new Directory("WEB-INF");

		webInf.add(cGif);
		conf.add(jdbcProps);
		webApp.add(webInf);
		webApp.add(conf);
		webApp.add(custOver);
		
		webApp.show("");

	}

}
