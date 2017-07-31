package assignment.exceptionhandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Storage {
	private Map<ProjectDetails, Set<ActionDetails>> projectHashMap = new HashMap<>();
	
	public void addProject(ProjectDetails pd) {
		projectHashMap.put(pd, new HashSet<ActionDetails>());
	}
		
	public Set<ActionDetails> getActionSet(ProjectDetails pd) {
		return projectHashMap.get(pd);
	}
	
	public Map<ProjectDetails, Set<ActionDetails>> getMap() {
		return projectHashMap;
	}
}
