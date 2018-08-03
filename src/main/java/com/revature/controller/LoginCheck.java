package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDao;
import com.revature.model.Employee;

/**
 * Servlet implementation class LoginCheck
 */
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  response.setContentType("text/html;charset=UTF-8");
		  
		  PrintWriter out = response.getWriter();
		  System.out.println("hellow");
		  String uname = request.getParameter("txtusername");
		  String pword = request.getParameter("txtpassword");
		  EmployeeDao dao = new EmployeeDao();
		  int i = 0;
		  List<Employee> employees = dao.getAllEmployees();
		  //System.out.println(uname);
		  //System.out.println(pword);
		  try {
		  for(Employee log : employees) {
			  System.out.println(log.getEmployee_email());
			  if(uname.equalsIgnoreCase(log.getEmployee_email()) && pword.equalsIgnoreCase(log.getEmployee_password()) && log.getE_department_id() == 2) {
				  HttpSession session = request.getSession();
				  session.setAttribute("user", uname);
				  RequestDispatcher rd=request.getRequestDispatcher("Managerdash.html");
				  session.setAttribute("userid", log.getEmployee_id());
				 // System.out.println("the employee id: " + (String) session.getAttribute("userid"));
				  rd.forward(request, response);
				  i = 2;
			  }
			  if(uname.equalsIgnoreCase(log.getEmployee_email()) && pword.equalsIgnoreCase(log.getEmployee_password()) && log.getE_department_id() == 1) {
				  HttpSession session = request.getSession();
				  session.setAttribute("user", uname);
				  RequestDispatcher rd=request.getRequestDispatcher("Employeedash.html");
				  session.setAttribute("userid", log.getEmployee_id());
				 // System.out.println("the employee id: " + (String) session.getAttribute("userid"));
				  rd.forward(request, response);
				  i = 1;
			  }
		  }
		  if(i ==0) {
			  RequestDispatcher rd=request.getRequestDispatcher("index.html");
			  rd.include(request, response);
		  }
		  }finally {
			  out.close();
		  }/*
		  try {
			  if(uname.equalsIgnoreCase("joe") && pword.equalsIgnoreCase("joe")) {
				  HttpSession session = request.getSession();
				  session.setAttribute("user", uname);
				  RequestDispatcher rd=request.getRequestDispatcher("Managerdash.html");
				  rd.forward(request, response);
			  }else {
				  RequestDispatcher rd=request.getRequestDispatcher("index.html");
				  rd.include(request, response);
			  }
		  }finally {
			  out.close();
		  }*/
	}

}
