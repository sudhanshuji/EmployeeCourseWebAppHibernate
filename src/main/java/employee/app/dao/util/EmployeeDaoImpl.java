package employee.app.dao.util;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import employee.app.entity.Course;
import employee.app.entity.Employee;
import employee.app.exceptions.DaoException;

public class EmployeeDaoImpl implements EmployeeDao {

	public EmployeeDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee getEmployeeByEmployeeId(int empId) throws DaoException {
		Session session = null;
		try {
			session = HibernateUtil.getHibernateSession();
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		String fetchEmployeeByEmployeeId = "from Employee employee where employee.empId = " + empId;

		try {

			Query<Employee> query = session.createQuery(fetchEmployeeByEmployeeId, Employee.class);
			return query.uniqueResult();

		} catch (HibernateException e) {


			throw new DaoException("There was an error while fetching  employee with employee ID " + empId, e);

		} finally {

			session.clear();
			session.close();

		}

	}

}
