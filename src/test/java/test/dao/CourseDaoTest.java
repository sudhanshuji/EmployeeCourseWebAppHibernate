package test.dao;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import employee.app.dao.CourseDao;
import employee.app.dao.CourseDaoImpl;
import employee.app.entity.Course;
import employee.app.entity.Employee;
import employee.app.entity.EmployeeCourse;
import employee.app.exceptions.DaoException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CourseDaoTest {
	private static CourseDao courseImpl;

	@BeforeClass
	public static void instatntiate() {
		courseImpl = new CourseDaoImpl();
	}
	
	

	@Test
	public void test1AddCourse() {
//		CourseDao courseImpl = new CourseDaoImpl();
//		Course course = new Course();

		List<EmployeeCourse> empCourseList = new ArrayList<EmployeeCourse>();
		/*
		 * EmployeeCourse empCourse1 = new EmployeeCourse(1001, 102,
		 * CourseStatus.Assigned.name(), new Date(), new Date()); EmployeeCourse
		 * empCourse2 = new EmployeeCourse(1002, 101, CourseStatus.Assigned.name(), new
		 * Date(), new Date()); EmployeeCourse empCourse3 = new EmployeeCourse(1003,
		 * 103, CourseStatus.Assigned.name(), new Date(), new Date());
		 * 
		 * empCourseList.add(empCourse1); empCourseList.add(empCourse2);
		 * empCourseList.add(empCourse3);
		 */

		Course course = new Course(106, "GitHub", 12, "Java");
//		Course course = new Course(105, "Core Java", 30, "Java");
		try {
			assertTrue(courseImpl.addCourse(course));
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("In catch block");
		}

	}

	/*
	 * @Test public void test2GetAllCourse() { // CourseDao courseImpl =
	 * newCourseDaoImpl(); ArrayList<String> courseList = new ArrayList();
	 * courseList.add("SpringBoot"); courseList.add("HTML");
	 * 
	 * // Course course = new Course(); // Course course = new Course(102, "COBOL",
	 * 30, "Mainframe");
	 * 
	 * try { assertEquals(courseList, courseImpl.getAllCourse()); } catch
	 * (DaoException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * fail(e.getMessage()); } }
	 */

	/*
	 * @Test public void test3DeleteCourse() { // CourseDao courseImpl = new
	 * CourseDaoImpl(); // Course course = new Course(); // Course course = new
	 * Course(102, "COBOL", 30, "Mainframe"); try {
	 * assertTrue(courseImpl.deleteCourse(102)); } catch (DaoException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } }
	 * 
	 * @Test public void test4getAllCourseByDomain() { List<Course> courses = new
	 * ArrayList(); try { courses = courseImpl.getAllCourseByDomain("Java"); } catch
	 * (DaoException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * System.out.println(courses.size()); for (Course course : courses) {
	 * System.out.println(course.getCourseId());
	 * System.out.println(course.getCourseName());
	 * System.out.println(course.getDuration());
	 * System.out.println(course.getDomain()); } }
	 */

	@Test
	public void test5RegisterForCourse() {
		Employee emp1 = new Employee(1, "Shyam", "3A");
		Course course1 = new Course(104, "Springboot", 25, "Java");
		EmployeeCourse empCourse = new EmployeeCourse("Completed", new Date(), new Date(), course1, emp1);

		try {
			assertTrue(courseImpl.assignCourseToEmployee(empCourse));
		} catch (DaoException e) { // TODO Auto-generated catch block
			e.printStackTrace();
			fail(e.getMessage());
		} // fail("Not yet implemented");
	}
	
	@Test
	public void test6GetAllCourseByDomain() {
		// CourseDao courseImpl = newCourseDaoImpl();
		ArrayList<String> courseList = new ArrayList<String>();
		courseList.add("Springboot");
		courseList.add("HTML");
		String domain = "Java";
		List<String> courseResultList = new ArrayList<String>();
		try {
			List<Course> coursesFetched = courseImpl.getAllCourseByDomain(domain);
//			for(Course c:coursesFetched) {
//				courseResultList.add(c.getCourseName());
//				
//			}
			assertTrue(coursesFetched.size()>0);
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		// Course course = new Course();
		// Course course = new Course(102, "COBOL", 30, "Mainframe");

		
	}

}
