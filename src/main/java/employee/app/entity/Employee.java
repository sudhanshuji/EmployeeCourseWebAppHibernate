package employee.app.entity;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

/**
 * 
 * @author saura
 *
 */
@Entity
public class Employee {

	@Id
	private int empId;

	private String empName;
	private String joblevel;

//	@OneToMany
//	private List<TaggedResources> resources;

//	@OneToMany(cascade = CascadeType.ALL)
//	private List<EmployeeCourse> empCourseIds;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param empId
	 * @param empName
	 * @param joblevel
	 */

	/**
	 * @return the empId
	 */
	public int getEmpId() {
		return empId;
	}

//	public List<TaggedResources> getResources() {
//		return resources;
//	}
//
//	public void setResources(List<TaggedResources> resources) {
//		this.resources = resources;
//	}

	public Employee(int empId, String empName, String joblevel/* , List<TaggedResources> resources */) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.joblevel = joblevel;
//		this.resources = resources;
	}

//	public List<EmployeeCourse> getEmpCourseIds() {
//		return empCourseIds;
//	}
//
//	public void setEmpCourseIds(List<EmployeeCourse> empCourseIds) {
//		this.empCourseIds = empCourseIds;
//	}

//	public Employee(int empId, String empName, String joblevel, List<EmployeeCourse> empCourseIds) {
//		super();
//		this.empId = empId;
//		this.empName = empName;
//		this.joblevel = joblevel;
//		this.empCourseIds = empCourseIds;
//	}

	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * @return the joblevel
	 */
	public String getJoblevel() {
		return joblevel;
	}

	/**
	 * @param joblevel the joblevel to set
	 */
	public void setJoblevel(String joblevel) {
		this.joblevel = joblevel;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId, empName, joblevel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return empId == other.empId && Objects.equals(empName, other.empName)
				&& Objects.equals(joblevel, other.joblevel);
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", joblevel=" + joblevel + "]";
	}

}
