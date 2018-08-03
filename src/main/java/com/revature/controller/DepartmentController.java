package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.DepartmentDao;
import com.revature.model.Department;

@WebServlet("/DepartmentController")
public class DepartmentController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		String favColor = (String) session.getAttribute("favColor");
		
		System.out.println(favColor);
		
		DepartmentDao dao = new DepartmentDao();
		List<Department> departments = dao.getAllDepartments();
		
		PrintWriter pw = resp.getWriter();
		for (Department c : departments) {
			pw.println(c.toString());
		}
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		Department d = mapper.readValue(req.getInputStream(), Department.class);
		
		System.out.println(d.toString());
		

		HttpSession session = req.getSession();
		session.invalidate();
	}

}
