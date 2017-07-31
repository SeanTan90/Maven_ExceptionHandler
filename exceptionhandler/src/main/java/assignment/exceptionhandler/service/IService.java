package assignment.exceptionhandler.service;

public interface IService {
	
	
	String HandleAction(String projectName, String moduleName, Exception e) throws InstantiationException, IllegalAccessException, ClassNotFoundException;
}
