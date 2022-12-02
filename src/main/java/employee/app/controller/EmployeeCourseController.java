package employee.app.controller;

import java.io.IOException;
import java.io.PrintWriter;

import employee.app.entity.Course;
import employee.app.exceptions.ManagerException;
import employee.app.manager.CourseManager;
import employee.app.manager.CourseManagerImpl;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EmployeeCourseController extends HttpServlet {
	CourseManager courseManager;

	public EmployeeCourseController() {
		super();
		System.out.println("MyController Constructor");
		this.courseManager = new CourseManagerImpl();
	}

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println(request.getRequestURI());

		System.out.println("Currently in service method in EmployeeCourseController");

		if (request.getRequestURI().endsWith("addCourse")) {
			insertCourse(request, response);
		}
	}

	private void insertCourse(HttpServletRequest request, HttpServletResponse response) {
		Integer courseId = Integer.parseInt(request.getParameter("courseId"));
		String courseName = request.getParameter("courseName");
		Integer duration = Integer.parseInt(request.getParameter("duration"));
		String domain = request.getParameter("domain");
		Course course = new Course(courseId, courseName, duration, domain);
		String result = null;

		try {
			if( courseManager.insertCourse(course))
				result = "Course added successfully";
			else
				result = "Some error";
		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		writer.append(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
