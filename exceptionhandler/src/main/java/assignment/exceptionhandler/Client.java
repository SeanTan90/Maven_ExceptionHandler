package assignment.exceptionhandler;

import assignment.exceptionhandler.service.Service;
import assignment.exceptionhandler.service.fileNameEmptyException;
import assignment.exceptionhandler.utility.xmlReader;

public class Client {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, fileNameEmptyException {
		String file = "D:\\Users\\seantan\\Desktop\\Playground\\exceptionlibrary.xml";
		
		Service service = new Service(file);
		System.out.println(service.HandleAction("bank", "withdraw", new ArithmeticException()));	
	}

}
