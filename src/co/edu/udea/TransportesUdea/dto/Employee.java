package co.edu.udea.TransportesUdea.dto;

import java.util.Date;

/**
 * 
 * @author Santiago
 *
 */

public class Employee {
	
	String id;
	String name;
	String lastName;
	double salary;
	String email;
	Date startDate;
	String password;
	
	public Employee() {
		super();
	}

	public Employee(String id, String name, String lastName, double salary, String email, Date startDate,
			String password) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.salary = salary;
		this.email = email;
		this.startDate = startDate;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	

	 
	
	
	
}
