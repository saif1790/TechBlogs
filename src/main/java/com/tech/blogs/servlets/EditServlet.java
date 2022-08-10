package com.tech.blogs.servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.cj.AbstractPreparedQuery;
import com.tech.blogs.dao.UserDAO;
import com.tech.blogs.entities.Message;
import com.tech.blogs.entities.User;
import com.tech.blogs.helper.DBConnection;
import com.tech.blogs.helper.FileHelper;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
@MultipartConfig
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String name = request.getParameter("editName");
		String email = request.getParameter("editEmail");
		String gender = request.getParameter("gender");
		String about = request.getParameter("editAbout");
		Part part = request.getPart("pic");
		String picName = part.getSubmittedFileName();

		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentUser");
		user.setName(name);
		user.setEmail(email);
		user.setGender(gender);
		user.setAbout(about);
		String oldPicPath =user.getProfilePic();
		System.out.println("Old Path"+oldPicPath);
		user.setProfilePic(picName);
		UserDAO dao = new UserDAO(DBConnection.getDBConnection());
		boolean updateUserStatus = dao.updateUser(user);
		if (updateUserStatus) {
			@SuppressWarnings("deprecation")
			String path = request.getRealPath("/") + "pics" + File.separator + user.getProfilePic();
			String Oldpath = request.getRealPath("/") + "pics" + File.separator + oldPicPath;
			System.out.println(path);
			FileHelper.deleteFile(Oldpath);
			if (FileHelper.saveFile(part.getInputStream(), path)) {

				Message msg = new Message("Profile updated Successfully....", "success", "alert-success");
				session = request.getSession();
				session.setAttribute("msg", msg);
				out.println("Profile updated");
			}
		} else {
			out.println("something went wrong");
		}

	}

}
