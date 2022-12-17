package employee.app.dao;

import employee.app.entity.Employee;
import employee.app.exceptions.DaoException;

public interface EmployeeDao {

	Employee getEmployeeByEmployeeId(int empId) throws DaoException;

}
