package assignment.exceptionhandler.actions;

import java.util.Map;

import assignment.exceptionhandler.Action;

public class Email extends Action {


	@Override
	public void executeAction(Map<String, String> attributeDtls) {
		System.out.println("Send email");
	}
	
}
