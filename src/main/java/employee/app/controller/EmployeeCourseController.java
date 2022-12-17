package employee.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.google.gson.Gson;

import employee.app.dao.util.DataTransformer;
import employee.app.dto.CourseDto;
import employee.app.dto.EmployeeCourseDto;
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

		System.out.println("URL is - " + request.getRequestURL());

		if (request.getRequestURI().endsWith("addCourse")) {
			insertCourse(request, response);
		} else if (request.getRequestURI().endsWith("registerForCourse")) {
			registerForCourse(request, response);
		} else if (request.getRequestURI().endsWith("getCoursesByDomain")) {
			getCoursesByDomain(request, response);
		}

		//
	}

	private void getCoursesByDomain(HttpServletRequest request, HttpServletResponse response) {

		Gson gson = new Gson();
		String domain = request.getParameter("domain");

		System.out.println("On server: domain receoived as paramter is " + domain);

		try {
			PrintWriter writer = response.getWriter();
			List<Course> courses = courseManager.getAllCourseByDomain(domain);
			/*
			 * String coursesJson = gson.toJson(courses);
			 * 
			 * response.setContentType("application/json");
			 * 
			 * //response.setContentType("text/html");
			 * 
			 * writer.append(coursesJson);
			 */

			DataTransformer dataTransformer = new DataTransformer();
			/*
			 * Will use this dto list to create result for JSON response. Each object of the
			 * below list contains course ID, course name and course duration
			 */
			@SuppressWarnings("unused")
			List<CourseDto> couurseDtoList = dataTransformer.transformData(courses);

			response.setContentType("text/html");
			String outputHtml = dataTransformer.transformDataToHtml(courses);
			writer.append(outputHtml);
		} catch (ManagerException e) {
			e.printStackTrace();
		}

		catch (IOException e) {

			e.printStackTrace();
		}

	}

	private void registerForCourse(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Integer empId = Integer.parseInt(request.getParameter("employeeId"));
		Integer courseId = Integer.parseInt(request.getParameter("courseId"));
		String status = request.getParameter("status");
		String result = null;

		EmployeeCourseDto empCourseDto = new EmployeeCourseDto(empId, courseId, status);
		try {
			if (courseManager.registerForCourse(empCourseDto))
				result = " The requested course is assigned to employee successfully";
			else
				result = "Some error occured in registeration process";

		} catch (ManagerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatus(500);
			result = e.getMessage();
		}

		try {
			response.setContentType("text/html");
			PrintWriter writer = response.getWriter();
			writer.append(result);
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
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
			if (courseManager.insertCourse(course))
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
