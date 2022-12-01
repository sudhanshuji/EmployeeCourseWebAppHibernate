package employee.app.entity;

public enum CourseDomain {
	Java("Java"), DotNet("Dotnet"), Mainframe("Mainframe"), Devops("Devops"), Webtech("Web Technology"),
	BI("Business Intelligence");

	public final String val;

	CourseDomain(String data) {
		this.val = data;
	}

//	public String toString() {
//		return value;
//	}

}
