package employee.app.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import employee.app.dao.util.CourseDao;
import employee.app.dao.util.CourseDaoImpl;
import employee.app.dao.util.EmployeeDao;
import employee.app.dao.util.EmployeeDaoImpl;
import employee.app.dto.EmployeeCourseDto;
import employee.app.entity.Course;
import employee.app.entity.CourseDomain;
import employee.app.entity.CourseStatus;
import employee.app.entity.Employee;
import employee.app.entity.EmployeeCourse;
import employee.app.exceptions.DaoException;
import employee.app.exceptions.ManagerException;

public class CourseManagerImpl implements CourseManager {

	CourseDao courseDao;

	EmployeeDao employeeDao;

	public CourseManagerImpl() {

		courseDao = new CourseDaoImpl();
		employeeDao = new EmployeeDaoImpl();
	}

	@Override
	public String validateCourseDomain(String domainToValidate) {
		// TODO Auto-generated method stub
		boolean isValid = false;
		String domainName = "";

		CourseDomain.values();

		for (CourseDomain domain : CourseDomain.values()) {
			if (domain.name().equalsIgnoreCase(domainToValidate)) {
				isValid = true;
				domainName = domain.name();
			}
		}

//		for (CourseDomain domain : CourseDomain.values()) {
//			if (domain.val.equalsIgnoreCase(domainToValidate)) {
//				isValid = true;
//				domainName = domain.val;
//			}
//		}

		return domainName;
	}

	@Override
	public boolean validateCourse(Course course) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean insertCourse(Course course) throws ManagerException {
		// TODO Auto-generated method stub
		CourseDao courseDao = new CourseDaoImpl();
		try {
			return courseDao.addCourse(course);
		} catch (DaoException e) {
			throw new ManagerException(e);
		}

	}

	@Override
	public List<Course> getAllCourseByDomain(String domain) throws ManagerException {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<Course>();
		try {
			courses = courseDao.getAllCourseByDomain(domain);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			throw new ManagerException(e);
		}
		return courses;
	}

	@Override
	public boolean registerForCourse(EmployeeCourseDto empCourseDto) throws ManagerException {
		// TODO Auto-generated method stub
		boolean result = false;

		try {
			Employee employee = employeeDao.getEmployeeByEmployeeId(empCourseDto.getEmpId());
			Course course = courseDao.getCourseByCourseId(empCourseDto.getCourseId());
			EmployeeCourse empCourse = new EmployeeCourse(empCourseDto.getStatus(), new Date(), new Date(), course,
					employee);
			result = courseDao.assignCourseToEmployee(empCourse);
		} catch (DaoException e) {
			throw new ManagerException(e);
		}
		return result;

	}

}
