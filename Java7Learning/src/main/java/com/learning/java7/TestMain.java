package com.learning.java7;
/*
Features 
- Type inference
  List<Integer> primes = new ArrayList<>();
- String in switch
- Automatic resource management
  try(FileInputStream fin = new FileInputStream("info.xml");) 
  {
	  ....
  }
  catch(FileNotFoundException ex)
  {
  }
  catch(IOException ex)
  {
  }
- Catching Multiple Exception Type in Single Catch Block - above example can be simplified
  try(FileInputStream fin = new FileInputStream("info.xml");) 
  {
	  ....
  }
  catch(FileNotFoundException | IOException ex)
  {
  }
- Underscore in numeric literals
- Binary Literals with prefix "0b"
- ForkJoinPool

*/
public class TestMain {

	public static void main(String[] args) {
	}

}
