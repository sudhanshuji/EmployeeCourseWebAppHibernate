package employee.app.dao.util;

import java.util.ArrayList;
import java.util.List;

import employee.app.dto.CourseDto;
import employee.app.entity.Course;

public class DataTransformer {

	public DataTransformer() {
	}

	public List<CourseDto> transformData(List<Course> courses) {

		List<CourseDto> list = new ArrayList<>();

		for (Course course : courses) {
			CourseDto dto = new CourseDto();
			dto.setCourseId(course.getCourseId());
			dto.setCourseName(course.getCourseName());
			dto.setDurationInHours(course.getDuration());
		}

		return list;
	}

	public String transformDataToHtml(List<Course> courses) {

		String html = "<select name='courseId' id=\"course\">";
		html += "<option value=\"---\">Course Name, Duration</option>";

		for (Course course : courses) {

			html += "<option value=" + course.getCourseId() + ">";
			
			html += course.getCourseName() + ", " + course.getDuration();

			html += "</option>";
		}

		html += "</select>";
		return html;
	}

}
