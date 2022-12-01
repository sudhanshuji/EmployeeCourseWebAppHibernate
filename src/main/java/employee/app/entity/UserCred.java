package employee.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "User_Credentials")
public class UserCred {

	@Id
	@Column(name = "user_name")
	private String username;
	@Column(name = "Password")
	private String password;
	@OneToOne
	private Employee employee;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public UserCred() {
		// TODO Auto-generated constructor stub

	}

	public UserCred(String username, String password, Employee employee) {
		super();
		this.username = username;
		this.password = password;
		this.employee = employee;
	}

	/**
	 * @param username
	 * @param password
	 * @param employee
	 */

}
