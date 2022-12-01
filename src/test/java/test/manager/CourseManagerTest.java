package test.manager;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import employee.app.dto.EmployeeCourseDto;
import employee.app.entity.CourseStatus;
import employee.app.exceptions.ManagerException;
import employee.app.manager.CourseManager;
import employee.app.manager.CourseManagerImpl;

public class CourseManagerTest {

	private static CourseManager courseManager;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		courseManager = new CourseManagerImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testValidateCourseDomain() {
	}

	@Test
	public void testValidateCourse() {
	}

	@Test
	public void testInsertCourse() {
		
	}

	@Test
	public void testGetAllCourseByDomain() {
		
	}

	@Test
	public void testRegisterForCourse() {
		EmployeeCourseDto empCourseDto = new EmployeeCourseDto(1, 104, CourseStatus.Assigned.name());

		try {
			assertTrue(courseManager.registerForCourse(empCourseDto));
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
	}

}
