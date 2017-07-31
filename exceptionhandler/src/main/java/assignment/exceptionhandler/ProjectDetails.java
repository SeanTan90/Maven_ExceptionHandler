package assignment.exceptionhandler;

public class ProjectDetails {
	private String projectName;
	private String moduleName;
	private String exceptionType;
	

	public ProjectDetails(String projectName, String moduleName, String exceptionType) {
		this.projectName = projectName;
		this.moduleName = moduleName;
		this.exceptionType = exceptionType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((exceptionType == null) ? 0 : exceptionType.hashCode());
		result = prime * result + ((moduleName == null) ? 0 : moduleName.hashCode());
		result = prime * result + ((projectName == null) ? 0 : projectName.hashCode());
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
		ProjectDetails other = (ProjectDetails) obj;
		if (exceptionType == null) {
			if (other.exceptionType != null)
				return false;
		} else if (!exceptionType.equals(other.exceptionType))
			return false;
		if (moduleName == null) {
			if (other.moduleName != null)
				return false;
		} else if (!moduleName.equals(other.moduleName))
			return false;
		if (projectName == null) {
			if (other.projectName != null)
				return false;
		} else if (!projectName.equals(other.projectName))
			return false;
		return true;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public void setExceptionType(String exceptionType) {
		this.exceptionType = exceptionType;
	}

	public String getProjectName() {
		return projectName;
	}
	
	public String getModuleName() {
		return moduleName;
	}
	
	public String getExceptionType() {
		return exceptionType;
	}

}
