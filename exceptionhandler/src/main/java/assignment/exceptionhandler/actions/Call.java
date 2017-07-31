package assignment.exceptionhandler.actions;

import java.util.Map;

import assignment.exceptionhandler.Action;

public class Call extends Action {

	

	@Override
	public void executeAction(Map<String, String> attributes) {
		System.out.println("Made call");
		
	}
}

