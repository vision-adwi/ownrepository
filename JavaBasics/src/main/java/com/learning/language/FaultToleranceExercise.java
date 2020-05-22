package com.learning.language;

import java.io.IOException;
import java.sql.SQLException;

import javax.xml.bind.JAXBException;

public class FaultToleranceExercise {

	public static void main(String[] args) {
		ExceptionThrow obj = new ExceptionThrow();
		obj.softError(); //This throws unchecked exception
		//obj.maliciousJob(); //This need to be handled as this throws checked-exception
		
		ExceptionThrow obj1 = new ExceptionThrow();
		try {
			obj1.softError();
		}
		catch(IllegalArgumentException e) {
		}
		/* Not possible as NumberFormatException is the subclass of IllegalArgumentException
		catch(NumberFormatException e) {
		}*/
		catch(Exception e) {
		}
		
		ExceptionThrow obj2 = new ExceptionThrow();
		try {
			obj2.softError();
		}
		/* Not possible if both the exception falls in same hierarchy
		catch(NumberFormatException | IllegalArgumentException e) {
		}*/
		catch(IllegalArgumentException e) {
		}
		
		ExceptionThrow obj3 = new ExceptionThrow();
		try {
			obj3.simpleMsg();
		}
		catch(RuntimeException e) {
			
		}
		catch(Exception e) {
			
		}
		
		ExceptionThrow obj4 = new ExceptionThrow();
		try {
			obj4.maliciousJob();
		}
		catch(IOException | SQLException e) {
			//e = new Exception(); //In case of multi catch, exception object is final
		}
		//Below is checked exception which is not thrown from try block
		/*catch(JAXBException e) {
		}*/
		catch(Exception e) {
			e = new Exception();
		}
		
		ExceptionCatch eCatch = new ExceptionCatch();
		try {
			System.out.println(eCatch.go());
		}
		catch(IOException e) {
			System.out.println("Here is exception !!!");
		}

	}
	

}
/*
1. Permissible combinations - a) try { } catch() { } finally { } b) try { } catch() { } c) try { } finally { }
2. Hierarchy        										Runtime Exception
                                   					
                                   			Exception		IOException	
                     										SQLException
                     Throwable															InternalError
                     						Error			VirtualMachineError 		OutOfMemoryError
                     																	StackOverflowError
                     										LinkageError				NoClassDefFoundError
3. Runtime exceptions - are mostly those which arises due to language operations like - ArithmeticException, NullPointerException,
ArrayIndexOutOfBoundException, ClassCastException, IllegalArgumentException etc.
4. Checked exceptions - 
5. Handling - Caller need not to handle exception if method throws unchecked exception(even explicitly), contrary to that all the
checked exceptions should be handled by caller.
6. Exception Handling - a) absorb it - caller can absorb it by surrounding it through try{ } catch() { } and do nothing in catch block;
					    b) tunnel it - pass it on to the caller who is supposed to call this method by suffixing throws clause in the
					    method.
					    c) intercept it - intercept it through through try{ } catch() { } and do whatever you want to before passing it
					    on by throw clause(throws clause[in method signature] it still needed if that is checked exception)
7. Handling sequence - I. If the multiple exception to be caught falls in a hierarchy then specialized one should be caught first otherwise
					   compiler complains. It complains as the catch block for specialized exception is unreachable code.
					  II. Post java 7, in case of multiple catch, exceptions should not fall in the hierarchy. Only the most generalized one 
					   should be considered. 
					 III. In case of multiple catch, exception object is final. It can not be re assigned.
8. Overriding - a) Overriding method can throw any exception(Runtime, Checked) if overridden method has thrown no exception.
    			b) If overridden method throws checked exception then overriding method has 4 options
    			   1. Can throw no exception
    			   2. Can throw same exception
    			   3. Can throw super classes of the exception
    			   4, Can throw any runtime exception
    			c) If overridden method throws runtime exception then a) ie. no rule.
    			   
9. Caveat - i) A method can throws any exception(checked or unchecked) even though it's body is not likely to throw any.
		   ii) If you throw any unchecked exception in your body but not throwing in method that is absolutely fine but contrary to that
		      you have to throw the respective exception in method if you throw it in body for all checked exceptions.
		  iii) A method call can be surrounded by try catch block even the method is not throwing any exception... but it can only catch
		       RuntimeException(or it's subclasses) and not any checked exception. 
		  iii) finally block is always executed except when JVM crashes, or you call System.exit() or Runtime.exit() from the try block.
		   iv) catching Throwable, Error or Exception is possible but it should be avoided to catch Throwable/Error.
            v) If there is return statement in finally block then exception in try block will be suppressed(even an exception is present).

*/

/*
BEST PRACTICES
- Clean up resources in finally block OR use Try-With-Resource.
- Prefer specific exception - instead of using just for sake.
- Document the exceptions you specify - use @throw to document possible Exception thrown by any method.
- Never catch Throwable
- Avoid converting Checked Exception into RuntimeException
- Don't ignore exception - Log it properly. Avoid empty catch blocks.
- Always provide meaning full message on Exception
- Including cause of Exception in stack-trace
- Don't catch, log and throw as it is - It is not adding any value.
- Wrap the exception without consuming it - wrap it to a custom one.
- Use Standard Exceptions - Reusing standard exception makes code more readable.
- Use Checked Exception for Recoverable error and Unchecked Exception for programming error.
*/

class ExceptionThrow {
	public void maliciousJob() throws IOException, SQLException {
		//throw new IOException();
		
	}
	
	public void softError() throws NumberFormatException {
		//throw new NumberFormatException();
	}
	
	public void simpleMsg() {
		System.out.println("Without exception !!!");
	}
}

class ExceptionThrowChild {
	public void maliciousJob() throws Exception{
		//throw new IOException();
		
	}
	
	public void softError() throws NullPointerException, IOException {
		//throw new NumberFormatException();
	}
	
	public void simpleMsg() throws IOException, NullPointerException {
		System.out.println("Without exception !!!");
	}
}

class ExceptionCatch {
	public int go() throws IOException {
		try {
			throw new IOException();
		}
		finally {
			return 10;
		}
	}
}