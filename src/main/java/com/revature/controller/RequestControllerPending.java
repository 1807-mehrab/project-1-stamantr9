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
 * Servlet implementation class RequestControllerPending
 */
public class RequestControllerPending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestControllerPending() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String favColor = (String) session.getAttribute("favColor");

		System.out.println(favColor);
		
		RequestDao dao = new RequestDao();
		List<Request> requests = dao.getAllPendingRequests();

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
		String favColor = (String) session.getAttribute("favColor");

		System.out.println(favColor);
		
		RequestDao dao = new RequestDao();
		List<Request> requests = dao.getAllResolvedRequests();

		PrintWriter pw = response.getWriter();
		for (Request c : requests) {
		pw.println(c.toString());
	}
	pw.close();
	}

}
