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
 * Servlet implementation class CreateRequest
 */
public class CreateRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int email = (int) session.getAttribute("userid");
		int amount = Integer.parseInt(request.getParameter("amount"));
		
		RequestDao dao = new RequestDao();
		dao.createRequest(email, amount);
		RequestDispatcher rd=request.getRequestDispatcher("Employeedash.html");

		PrintWriter pw = response.getWriter();
		rd.forward(request, response);
	pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int email = (int) session.getAttribute("userid");
		int amount = Integer.parseInt(request.getParameter("resolve"));
		int r_id = Integer.parseInt(request.getParameter("id"));
		
		RequestDao dao = new RequestDao();
		dao.updateRequest(r_id, amount, email);
		RequestDispatcher rd=request.getRequestDispatcher("Managerdash.html");

		PrintWriter pw = response.getWriter();
		rd.forward(request, response);
	pw.close();
	}

}
