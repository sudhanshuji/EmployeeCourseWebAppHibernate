package employee.app.dao.util;

import java.util.ArrayList;
import java.util.List;

import employee.app.entity.Course;
import employee.app.entity.Employee;
import employee.app.entity.EmployeeCourse;
import employee.app.exceptions.DaoException;

public interface CourseDao {

	boolean addCourse(Course course) throws DaoException;

	boolean deleteCourse(int CourseId) throws DaoException;

	List<Course> getAllCourse() throws DaoException;

	List<Course> getAllCourseByDomain(String domain) throws DaoException;
	
//	Employee getEmployeeB

	boolean assignCourseToEmployee(EmployeeCourse empCourse) throws DaoException;

	Course getCourseByCourseId(int courseId) throws DaoException;

}
