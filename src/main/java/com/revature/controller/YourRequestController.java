package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.RequestDao;
import com.revature.model.Request;

/**
 * Servlet implementation class YourRequestController
 */
public class YourRequestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YourRequestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int email = (int) session.getAttribute("userid");
		int resolved = 0;

		System.out.println(email);
		
		RequestDao dao = new RequestDao();
		List<Request> requests = dao.getYourFilterRequests(email, resolved);

		PrintWriter pw = response.getWriter();
		for (Request c : requests) {
		pw.println(c.toString());
	}
	pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int email = (int) session.getAttribute("userid");
		int resolved = 1;

		System.out.println(email);
		
		RequestDao dao = new RequestDao();
		List<Request> requests = dao.getYourFilterRequests(email, resolved);

		PrintWriter pw = response.getWriter();
		for (Request c : requests) {
		pw.println(c.toString());
	}
	pw.close();
	}

}
