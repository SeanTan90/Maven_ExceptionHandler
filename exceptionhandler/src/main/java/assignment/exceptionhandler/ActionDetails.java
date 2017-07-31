package assignment.exceptionhandler;

import java.util.Map;

public class ActionDetails {
	private String actionName;
	private Map<String, String> attributeDtls;
	

	public ActionDetails(String actionName, Map<String, String> attributeDtls) {
		this.actionName = actionName;
		this.attributeDtls = attributeDtls;
	
	}


	public String getActionName() {
		return actionName;
	}


	public void setActionName(String actionName) {
		this.actionName = actionName;
	}


	public Map<String, String> getAttributeDtls() {
		return attributeDtls;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attributeDtls == null) ? 0 : attributeDtls.hashCode());
		result = prime * result + ((actionName == null) ? 0 : actionName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActionDetails other = (ActionDetails) obj;
		if (attributeDtls == null) {
			if (other.attributeDtls != null)
				return false;
		} else if (!attributeDtls.equals(other.attributeDtls))
			return false;
		if (actionName == null) {
			if (other.actionName != null)
				return false;
		} else if (!actionName.equals(other.actionName))
			return false;
		return true;
	}


	public void setActionDtls(Map<String, String> actionDtls) {
		this.attributeDtls = actionDtls;
	}
}
