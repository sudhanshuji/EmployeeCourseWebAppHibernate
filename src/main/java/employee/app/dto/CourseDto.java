package employee.app.dto;

import java.util.Objects;

public class CourseDto {

	private int courseId;

	private String courseName;

	private int durationInHours;

	public CourseDto() {
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

	public int getDurationInHours() {
		return durationInHours;
	}

	public void setDurationInHours(int durationInHours) {
		this.durationInHours = durationInHours;
	}

	public CourseDto(int courseId, String courseName, int durationInHours) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.durationInHours = durationInHours;
	}

	@Override
	public int hashCode() {
		return Objects.hash(courseId, courseName, durationInHours);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseDto other = (CourseDto) obj;
		return courseId == other.courseId && Objects.equals(courseName, other.courseName)
				&& durationInHours == other.durationInHours;
	}

}
