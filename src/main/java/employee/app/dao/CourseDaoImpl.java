package employee.app.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import employee.app.dao.util.HibernateUtil;
import employee.app.entity.Course;
import employee.app.entity.Employee;
import employee.app.entity.EmployeeCourse;
import employee.app.exceptions.DaoException;

public class CourseDaoImpl implements CourseDao {

	public CourseDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addCourse(Course course) throws DaoException {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getHibernateSession();

			tx = session.beginTransaction();

			try {

				session.persist(course);
				// session.save(course);

				// Hibernate returns the generated Id after save
				Integer generatedId = course.getCourseId();

				tx.commit();

				return true;
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				throw new DaoException("There was an error in adding Course\n " + course + " \nto database", e1);
			}
		} catch (HibernateException e) {

			e.printStackTrace();

			tx.rollback();
			throw new DaoException("There was an error in adding Course\n " + course + " \nto database", e);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DaoException("There was an error in adding Course\n " + course + " \nto database", e);
		} finally {

//			session.clear();
//			session.close();

		}

	}

	@Override
	public boolean deleteCourse(int courseId) throws DaoException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Course> getAllCourse() throws DaoException {
		Session session = null;
		try {
			session = HibernateUtil.getHibernateSession();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String fetchAllCourses = "from Course";

		try {

			Query<Course> query = session.createQuery(fetchAllCourses, Course.class);
			@SuppressWarnings("unchecked")
			List<Course> departmentList = query.list();
			return departmentList;

		} catch (HibernateException e) {

			e.printStackTrace();

			throw new DaoException("There was an error while fetching all departments", e);

		} finally {

			session.clear();
			session.close();

		}
	}

	@Override
	public boolean assignCourseToEmployee(EmployeeCourse empCourse) throws DaoException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.getHibernateSession();

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Transaction tx = session.beginTransaction();
		try {

			session.merge(empCourse);

			// Hibernate returns the generated Id after save
			Integer generatedId = empCourse.getCourse().getCourseId();

			tx.commit();

			return true;

		} catch (HibernateException e) {

			e.printStackTrace();

			tx.rollback();
			throw new DaoException("There was an error in assigning employee course\n " + empCourse + " \nto database",
					e);

		} finally {

			session.clear();
			session.close();

		}

	}

	@Override
	public List<Course> getAllCourseByDomain(String domain) throws DaoException {
		Session session = null;
		try {
			session = HibernateUtil.getHibernateSession();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String fetchCourseByDomain = "From Course  course where course.domain = '" + domain + "'";

		try {

			Query<Course> query = session.createQuery(fetchCourseByDomain, Course.class);
			return query.list();

		} catch (HibernateException e) {

			e.printStackTrace();

			throw new DaoException("There was an error while fetching Course by domain\n " + domain, e);

		} finally {

			session.clear();
			session.close();

		}

	}

	@Override
	public Course getCourseByCourseId(int courseId) throws DaoException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.getHibernateSession();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		String fetchCourseByCourseId = "from Course course where course.courseId = " + courseId;

		try {

			Query<Course> query = session.createQuery(fetchCourseByCourseId, Course.class);
			return query.uniqueResult();

		} catch (HibernateException e) {

			e.printStackTrace();

			throw new DaoException("There was an error while fetching  course with course ID " + courseId, e);

		} finally {

			session.clear();
			session.close();

		}

	}

}
