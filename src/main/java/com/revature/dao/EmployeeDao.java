package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Employee;
import com.revature.model.Request;
import com.revature.util.ConnectionUtil;

public class EmployeeDao {
	public List<Employee> getAllEmployees() {
		PreparedStatement ps = null;
		Employee c = null;
		List<Employee> Employees = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			System.out.println("made the connection");
			String sql = "SELECT * FROM EMPLOYEE";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String employee_name = rs.getString("employee_name");
				String employee_email = rs.getString("employee_email");
				String employee_password = rs.getString("employee_password");
				int department_id = rs.getInt("department_id");
				
				c = new Employee(employee_id, employee_name, employee_email, employee_password, department_id);
				Employees.add(c);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return Employees;
	}
	
	public List<Employee> viewEmployee(int email) {
		PreparedStatement ps = null;
		Employee c = null;
		List<Employee> requests = new ArrayList<>();
		ResultSet rs = null;
		System.out.println(email);
		
		try (Connection conn = ConnectionUtil.getConnection()) {
		String sql = "SELECT * FROM EMPLOYEE WHERE Employee_ID = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, email);
		
		rs = ps.executeQuery();
			while (rs.next()) {
				int employee_id = rs.getInt("employee_id");
				String employee_name = rs.getString("employee_name");
				String employee_email = rs.getString("employee_email");
				String employee_password = rs.getString("employee_password");
				int department_id = rs.getInt("department_id");
				
				c = new Employee(employee_id, employee_name, employee_email, employee_password, department_id);
				requests.add(c);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return requests;
	}
}
