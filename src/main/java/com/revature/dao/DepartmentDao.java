package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Department;
import com.revature.util.ConnectionUtil;

public class DepartmentDao {
	public List<Department> getAllDepartments() {
		PreparedStatement ps = null;
		Department c = null;
		List<Department> departments = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM DEPARTMENT";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				int department_id = rs.getInt("department_id");
				String department_name = rs.getString("department_name");
				
				c = new Department(department_id, department_name);
				departments.add(c);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return departments;
	}
}
