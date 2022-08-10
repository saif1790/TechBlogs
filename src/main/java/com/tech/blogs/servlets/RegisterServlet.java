package com.tech.blogs.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blogs.dao.UserDAO;
import com.tech.blogs.entities.User;
import com.tech.blogs.helper.DBConnection;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
@MultipartConfig
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean saveUserStatus = false;
		PrintWriter out = response.getWriter();

		// getting form data

		String userName = request.getParameter("username");
		String userEmail = request.getParameter("email");
		String userPassword = request.getParameter("password");
		String userGender = request.getParameter("gender");
		String abouUser = request.getParameter("about");
		String userAgreement = request.getParameter("agreement");

		/*
		 * out.println(userName); out.println(userEmail); out.println(userGender);
		 * out.println(abouUser); out.println(userAgreement);
		 */

		if (userAgreement == null) {
			out.println("please accept term & condition");
			out.println(userAgreement);
		} else {

			if (abouUser != "" && abouUser!=null) {
				// creating user object and setting its value from the form
				User user = new User(userName, userEmail, userPassword, userGender, abouUser);

				UserDAO dao = new UserDAO(DBConnection.getDBConnection());
				saveUserStatus = dao.saveUser(user);

				if (saveUserStatus == true) {
					out.println("User registered successfully");
				} else {
					out.println("something went wrong!!!");
				}
			}
			else {
				// creating user object and setting its value from the form
				User user = new User(userName, userEmail, userPassword, userGender);

				UserDAO dao = new UserDAO(DBConnection.getDBConnection());
				saveUserStatus = dao.saveUser(user);

				if (saveUserStatus) {
					out.println("User registered successfully");
				} else {
					out.println("something went wrong!!!");
				}
			}
		}

	}

}
