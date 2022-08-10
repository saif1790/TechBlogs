package com.tech.blogs.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tech.blogs.dao.UserDAO;
import com.tech.blogs.entities.Message;
import com.tech.blogs.entities.User;
import com.tech.blogs.helper.DBConnection;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String pass = request.getParameter("password");

		UserDAO dao = new UserDAO(DBConnection.getDBConnection());
		User user = dao.getUserByEmailAndPassword(email, pass);

		if (user != null) {
			if (email.equalsIgnoreCase(user.getEmail()) && pass.equals(user.getPassword())) {
				HttpSession session = request.getSession();
				session.setAttribute("currentUser", user);
				response.sendRedirect("profile.jsp");
			}

		} else {

			Message msg = new Message("Invalid Detail !! Try with Valid Cred", "error", "alert-danger");
			HttpSession session = request.getSession();
			session.setAttribute("msg", msg);
			request.getRequestDispatcher("login.jsp").include(request, response);
		}

	}

}
