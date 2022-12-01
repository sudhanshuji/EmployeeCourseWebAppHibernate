package employee.app.entity;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * @author saura
 *
 *         https://howtodoinjava.com/hibernate/unable-to-locate-persister-error/
 * 
 *         There are multiple solutions suggested in other blogs/websites but
 *         the solution that worked for me was to change the javax.persistence.*
 *         annotation to jakarta.persistence.* annotation in the hibernate
 *         entity classes.
 * 
 *         The reason is seen in the migration guide
 *         (https://docs.jboss.org/hibernate/orm/6.0/migration-guide/migration-guide.html)
 *         that Hibernate version 6.0 moves from Java Persistence as defined by
 *         the Java EE specs to Jakarta Persistence as defined by the Jakarta EE
 *         spec.
 * 
 *         Happy Learning !!
 */
@Entity
@Table(name = "courses")
public class Course {
	@Id
	private int courseId;
	private String courseName;
	private int duration;
	private String domain;
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<EmployeeCourse> empCourseIds;

	
	



//	public void setEmpCourseIds(List<EmployeeCourse> empCourseIds) {
//		this.empCourseIds = empCourseIds;
//	}

//	public Course(int courseId, String courseName, int duration, String domain, List<EmployeeCourse> empCourseIds) {
//		super();
//		this.courseId = courseId;
//		this.courseName = courseName;
//		this.duration = duration;
//		this.domain = domain;
//		this.empCourseIds = empCourseIds;
//	}
	
	

	/**
	 * @param courseId
	 * @param courseName
	 * @param duration
	 * @param domain
	 */
	public Course(int courseId, String courseName, int duration, String domain) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.duration = duration;
		this.domain = domain;
	}

	public Course() {
		// TODO Auto-generated constructor stub

	}

	

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId, courseName, domain, duration);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return courseId == other.courseId && Objects.equals(courseName, other.courseName)
				&& Objects.equals(domain, other.domain) && duration == other.duration;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", duration=" + duration + ", domain="
				+ domain + "]";
	}

}
