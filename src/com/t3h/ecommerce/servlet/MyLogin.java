package com.t3h.ecommerce.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.t3h.ecommerce.service.LoginService;

/**
 * Servlet implementation class MyLogin
 */
@WebServlet("/MyLogin")
public class MyLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyLogin() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		LoginService loginService = new LoginService();
		String res = loginService.testLogin(userName, password);
		if (res.equalsIgnoreCase("Password or username not true")) {
			request.setAttribute("str", res);
			request.getRequestDispatcher("login.jsp")
					.forward(request, response);
		} else {
			request.getSession().setAttribute("user", res);
			request.getRequestDispatcher("index.jsp")
			.forward(request, response);
		}
	}

}
