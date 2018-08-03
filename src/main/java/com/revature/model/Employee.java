package com.revature.model;

public class Employee {
	private int employee_id;
	private String employee_name;
	private String employee_email;
	private String employee_password;
	private int e_department_id;

	public int getEmployee_id() {
		return employee_id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_email() {
		return employee_email;
	}

	public void setEmployee_email(String employee_email) {
		this.employee_email = employee_email;
	}

	public String getEmployee_password() {
		return employee_password;
	}

	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}

	public int getE_department_id() {
		return e_department_id;
	}

	public void setE_department_id(int e_department_id) {
		this.e_department_id = e_department_id;
	}

	public void setEmployee_id(int Employee_id) {
		this.employee_id = Employee_id;
	}

	public String getedepartment_name() {
		return employee_name;
	}

	public void setEDepartment_id(int e_department_id) {
		this.e_department_id = e_department_id;
	}


	public Employee(int employee_id, String employee_name, String employee_email, String employee_password, int e_department_id) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_email = employee_email;
		this.employee_password = employee_password;
		this.e_department_id = e_department_id;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_email="
				+ employee_email + ", employee_password=" + employee_password + ", e_department_id=" + e_department_id
				+ "]" + "\n";
	}
	
}
