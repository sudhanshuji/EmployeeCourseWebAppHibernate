package employee.app.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import employee.app.dao.util.HibernateUtil;
import employee.app.entity.Employee;
import employee.app.exceptions.DaoException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final Logger LOGGER = LogManager.getLogger(EmployeeDaoImpl.class);

	public EmployeeDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Employee getEmployeeByEmployeeId(int empId) throws DaoException {
		Session session = null;
		try {
			session = HibernateUtil.getHibernateSession();
			LOGGER.info("Hibernate session established");
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		String fetchEmployeeByEmployeeId = "from Employee employee where employee.empId = " + empId;

		try {

			Query<Employee> query = session.createQuery(fetchEmployeeByEmployeeId, Employee.class);
			LOGGER.info("Result fetched from database");
			Employee employee = query.uniqueResult();
			LOGGER.debug("Result fetched from DB: " + employee.toString());
			return employee;

		} catch (HibernateException e) {

			throw new DaoException("There was an error while fetching  employee with employee ID " + empId, e);

		} finally {

			session.clear();
			session.close();

		}

	}

}
