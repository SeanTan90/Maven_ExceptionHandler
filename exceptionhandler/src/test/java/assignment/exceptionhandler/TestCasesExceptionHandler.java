package assignment.exceptionhandler;

import static org.junit.Assert.*;

import org.junit.Test;

import assignment.exceptionhandler.service.Service;
import assignment.exceptionhandler.service.fileNameEmptyException;

public class TestCasesExceptionHandler {

	@Test
	public void successfulExceptionHandling() {
		String file = "D:\\Users\\seantan\\Desktop\\Playground\\exceptionlibrary.xml";
		
		
		try {
		Service service = new Service(file);
		assertEquals("Success", service.HandleAction("bank", "withdraw", new ArithmeticException()));
		} catch (InstantiationException | IllegalAccessException | fileNameEmptyException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void nullProjectNameExceptionHandling() {
		String file = "D:\\Users\\seantan\\Desktop\\Playground\\exceptionlibrary.xml";
		
		try {
		Service service = new Service(file);
		assertEquals("Project Name cannot be found", service.HandleAction(null, "withdraw", new ArithmeticException()));
		} catch (InstantiationException | IllegalAccessException | fileNameEmptyException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void emptyProjectNameExceptionHandling() {
		String file = "D:\\Users\\seantan\\Desktop\\Playground\\exceptionlibrary.xml";
		
		try {
		Service service = new Service(file);
		assertEquals("Project Name cannot be found", service.HandleAction("", "withdraw", new ArithmeticException()));
		} catch (InstantiationException | IllegalAccessException | fileNameEmptyException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void nullModuleNameExceptionHandling() {
		String file = "D:\\Users\\seantan\\Desktop\\Playground\\exceptionlibrary.xml";
		
		try {
		Service service = new Service(file);
		assertEquals("Module Name cannot be found", service.HandleAction("bank", null, new ArithmeticException()));
		} catch (InstantiationException | IllegalAccessException | fileNameEmptyException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void emptyModuleNameExceptionHandling() {
		String file = "D:\\Users\\seantan\\Desktop\\Playground\\exceptionlibrary.xml";
		
		try {
		Service service = new Service(file);
		assertEquals("Module Name cannot be found", service.HandleAction("bank", "", new ArithmeticException()));
		} catch (InstantiationException | IllegalAccessException | fileNameEmptyException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void nullExceptionExceptionHandling() {
		String file = "D:\\Users\\seantan\\Desktop\\Playground\\exceptionlibrary.xml";
		
		try {
		Service service = new Service(file);
		assertEquals("Exception cannot be found", service.HandleAction("bank", "withdraw", null));
		} catch (InstantiationException | IllegalAccessException | fileNameEmptyException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test(expected = fileNameEmptyException.class) 
	public void nullFileNameExceptionHandling() throws InstantiationException, IllegalAccessException, ClassNotFoundException, fileNameEmptyException {
		String file = null;
			
		Service service = new Service(file);
		
	}
	
	

}
