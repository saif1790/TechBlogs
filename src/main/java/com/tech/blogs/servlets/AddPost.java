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

import com.tech.blogs.dao.PostDAO;
import com.tech.blogs.entities.Post;
import com.tech.blogs.entities.User;
import com.tech.blogs.helper.DBConnection;
import com.tech.blogs.helper.FileHelper;

/**
 * Servlet implementation class AddPost
 */
@WebServlet("/AddPost")
@MultipartConfig
public class AddPost extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPost() {
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
		int categotyId = Integer.parseInt(request.getParameter("categoryId"));
		String postTitle = request.getParameter("postTitle");
		String postContent = request.getParameter("postContent");
		String postCode = request.getParameter("postCode");

		// getting pic data
		Part part = request.getPart("postPic");
		String submittedPicName = part.getSubmittedFileName();

		// get current user id
 
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("currentUser");
          System.out.println("user id "+ user.getId());
		Post post = new Post(postTitle, postContent, postCode, submittedPicName, null, categotyId, user.getId());

		 PostDAO postDAO = new PostDAO(DBConnection.getDBConnection());
		 boolean savePost = postDAO.savePost(post);
		 if (savePost) {
			 String path = request.getRealPath("/") + "Blog_pics" + File.separator + submittedPicName;
			 System.out.println("blog path "+path);
			 FileHelper.saveFile(part.getInputStream(), path);
				/*
				 * Message msg = new Message("Post saved Successfully....", "success",
				 * "alert-success"); session.setAttribute("msg", msg);
				 * response.sendRedirect("profile.jsp"); System.out.println(msg);
				 */
			 out.print("done");
				 
		}
		 else {
			 out.print("error coming from servlet");
			 
			 
		}
		/*
		 * out.print(categotyId); out.print(postTitle); out.print(postContent);
		 * out.print(submittedPicName);
		 */
	}

}