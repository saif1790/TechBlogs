package com.tech.blogs.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tech.blogs.dao.LikeDAO;
import com.tech.blogs.helper.DBConnection;


@WebServlet("/LikeServlet")
public class LikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LikeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
             PrintWriter out = response.getWriter();
		
           int userId =Integer.parseInt(request.getParameter("userId"));
           int postId =Integer.parseInt(request.getParameter("postId"));
           String operation = request.getParameter("operation");
           
			/*
			 * out.println("response from server");
			 * out.println(userId+"--"+postId+"--"+operation);
			 */
           if(operation.equals("like"))
           {
        	   LikeDAO likeDAO = new LikeDAO(DBConnection.getDBConnection());
        	   boolean likeByUser1 = likeDAO.isLikeByUser(postId, userId);
        		 
        	   if(likeByUser1)
        	   {
        		   out.print("already liked");
        		    System.out.println("already liked");
        	   }
                     	   else {
        		   boolean insertLikesOnPost = likeDAO.insertLikesOnPost(postId, userId);
            	   out.print(insertLikesOnPost);
			}
        	  
           }
           else {
        	   out.print("something wrong");
		}
           
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
