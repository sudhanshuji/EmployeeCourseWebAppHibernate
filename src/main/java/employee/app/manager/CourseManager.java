package employee.app.manager;

import java.util.List;

import employee.app.dto.EmployeeCourseDto;
import employee.app.entity.Course;
import employee.app.exceptions.DaoException;
import employee.app.exceptions.ManagerException;

public interface CourseManager {
	String validateCourseDomain(String domain);

	boolean validateCourse(Course course);

	boolean insertCourse(Course course) throws ManagerException;

	List<Course> getAllCourseByDomain(String domain) throws ManagerException;

	boolean registerForCourse(EmployeeCourseDto empCourse) throws ManagerException;

}
