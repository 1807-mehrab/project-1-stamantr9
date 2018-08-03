package com.revature.model;

public class Department {
	private int department_id;
	private String department_name;

	public int getdepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	public String getdepartment_name() {
		return department_name;
	}

	public void setdepartment_name(String department_name) {
		this.department_name = department_name;
	}


	public Department(int department_id, String department_name) {
		super();
		this.department_id = department_id;
		this.department_name = department_name;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "department [department_id=" + department_id + ", department_name=" + department_name + "]" + "\n";
	}

	
}
