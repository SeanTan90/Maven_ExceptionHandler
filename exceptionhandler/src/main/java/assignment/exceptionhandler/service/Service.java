package assignment.exceptionhandler.service;

import java.util.Set;

import assignment.exceptionhandler.Action;
import assignment.exceptionhandler.ActionDetails;
import assignment.exceptionhandler.ProjectDetails;
import assignment.exceptionhandler.Storage;
import assignment.exceptionhandler.utility.xmlReader;

public class Service implements IService {
	Storage store = new Storage();
	
	public Service(String file) {
		xmlReader reader = new xmlReader(file, store);
		reader.parseXmlFile();
	}

	@Override
	public String HandleAction(String projectName, String moduleName, Exception e) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String exceptionType = e.getClass().getName();

		ProjectDetails pd = new ProjectDetails(projectName, moduleName, exceptionType); // key for searching the hashmap in store
		Set<ActionDetails> actionSet = store.getMap().get(pd);
		for(ActionDetails actDtls : actionSet) { 
			Class c = Class.forName("assignment.exceptionhandler.actions." + actDtls.getActionName());
			Object o = c.newInstance();
			
			Action a = (Action)o;
			a.executeAction(actDtls.getAttributeDtls());
			
			System.out.println(actDtls.getActionName() + actDtls.getAttributeDtls());
		}
		
		
		
		return "Success";
		
	}
}
