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

import com.revature.dao.RequestDao;
import com.revature.model.Request;

/**
 * Servlet implementation class FilterController
 */
public class FilterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out = response.getWriter();
		  //System.out.println("hello");
		  int uname = Integer.parseInt(request.getParameter("filterid"));
		  HttpSession session = request.getSession();
		  session.setAttribute("filtereduser", uname);
		  RequestDispatcher rd=request.getRequestDispatcher("Managerdash.html");
		  rd.forward(request, response);
		  out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int email = (int) session.getAttribute("filtereduser");

		System.out.println(email);
		
		RequestDao dao = new RequestDao();
		List<Request> requests = dao.getYourRequests(email);

		PrintWriter pw = response.getWriter();
		for (Request c : requests) {
		pw.println(c.toString());
	}
	pw.close();
	}

}
