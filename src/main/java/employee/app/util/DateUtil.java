package employee.app.util;

import java.util.Date;

public class DateUtil {

	public DateUtil() {
		// TODO Auto-generated constructor stub

	}

	public java.sql.Date convertJavaDateToSqlDate(java.util.Date date) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}

}
