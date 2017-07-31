package assignment.exceptionhandler.actions;

import java.util.Map;

import assignment.exceptionhandler.Action;

public class Sms extends Action {

	@Override
	public void executeAction(Map<String, String> attributes) {
		System.out.println("Send sms");
		
	}
}
