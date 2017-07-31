package assignment.exceptionhandler;

import static org.junit.Assert.*;

import org.junit.Test;

import assignment.exceptionhandler.service.Service;

public class TestCasesExceptionHandler {

	@Test
	public void test() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String file = "D:\\Users\\seantan\\Desktop\\Playground\\exceptionlibrary.xml";
		
		Service service = new Service(file);
		assertEquals("Success", service.HandleAction("bank", "withdraw", new ArithmeticException()));
	}

}
