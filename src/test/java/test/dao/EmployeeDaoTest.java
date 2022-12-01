package test.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import employee.app.dao.util.EmployeeDao;
import employee.app.dao.util.EmployeeDaoImpl;
import employee.app.exceptions.DaoException;

public class EmployeeDaoTest {

	public EmployeeDaoTest() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public void testGetEmployeeByEmployeeId() {
		int empId = 1;
		EmployeeDao employeeDao = new EmployeeDaoImpl();
		try {
			assertEquals(employeeDao.getEmployeeByEmployeeId(empId).getEmpName(), "Shyam");
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("Catch block: " + e.getMessage());
		}
	}
}
