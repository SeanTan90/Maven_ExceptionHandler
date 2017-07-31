package assignment.exceptionhandler.service;

public class fileNameEmptyException extends Exception {
	
	public fileNameEmptyException(String reason) {
		super(reason);
	}
}
