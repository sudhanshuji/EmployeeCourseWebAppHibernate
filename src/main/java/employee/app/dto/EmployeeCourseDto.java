package employee.app.dto;

public class EmployeeCourseDto {

	private int empId;
	private int courseId;
	private String status;

	public EmployeeCourseDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeCourseDto(int empId, int courseId,String status) {
		super();
		this.empId = empId;
		this.courseId = courseId;
		this.status = status;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

}
