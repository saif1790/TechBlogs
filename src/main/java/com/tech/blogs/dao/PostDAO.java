package com.tech.blogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxCursor.Fetch;
import com.tech.blogs.entities.Category;
import com.tech.blogs.entities.Post;

public class PostDAO {
	Connection connection;

	public PostDAO(Connection connection) {
		super();
		this.connection = connection;
	}
	
	
	public ArrayList<Category> getAllCategory()
	{
		ArrayList<Category> list = new ArrayList<>();
		 
		
		try {
			String query = "select * from categories";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Category category = new Category();
				 category.setCategoryId(rs.getInt(1));
				 category.setCategory_Name(rs.getString(2));
				 category.setDescription(rs.getString(3));
				 list.add(category);
				
			}
			
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean savePost(Post post) {
		boolean flag = false;
		try {

			String query = "insert into posts(post_Title,post_content,post_code,post_pic,category_Id,userId) values(?,?,?,?,?,?)";
			System.out.println(query);
			PreparedStatement psmt = connection.prepareStatement(query);
			psmt.setString(1, post.getPostTitle());
			psmt.setString(2, post.getPostContent());
			psmt.setString(3, post.getPostCode());
			psmt.setString(4, post.getPostPic());
			psmt.setInt(5, post.getCategoryId());
			psmt.setInt(6, post.getUserId());
			psmt.executeUpdate();
			flag=true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return flag;
	}

	public List<Post> getAllPost()
	{
		/* Fetch all post */
		
		List<Post> allPostList = new ArrayList<>();
		
		try {
			String query = "select * from posts order by post_Id desc";
			
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while (rs.next()) {
				 
				int postId = rs.getInt(1);
				String postTitle = rs.getString(2);
				String postContent = rs.getString(3);
				String postCode = rs.getString(4);
				String postPic = rs.getString(5);
				Timestamp postDate = rs.getTimestamp(6);
				int categoryId = rs.getInt(7);
				int userId = rs.getInt(8);
				
				Post post = new Post(postId, postTitle, postContent, postCode, postPic, postDate, categoryId, userId);
				allPostList.add(post);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
 		return allPostList;
	}

	public List<Post> getPostByCategoryId(int categoryId)
	{
List<Post> allPostList = new ArrayList<>();
		
		try {
			String query = "select * from posts where category_Id=? order by post_Id desc";
			
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setInt(1, categoryId);
			ResultSet rs = pstmt.executeQuery();
		 
			while (rs.next()) {
				 
				int postId = rs.getInt(1);
				String postTitle = rs.getString(2);
				String postContent = rs.getString(3);
				String postCode = rs.getString(4);
				String postPic = rs.getString(5);
				Timestamp postDate = rs.getTimestamp(6);
				int userId = rs.getInt(7);
				
				Post post = new Post(postId, postTitle, postContent, postCode, postPic, postDate, categoryId, userId);
				allPostList.add(post);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
 		return allPostList;
	}
	
	public Post getPost_ByPostID(int postId)
	{
		Post post =null;
		try {
			String query = "select * from posts where post_Id=?";
			PreparedStatement psmt= connection.prepareStatement(query);
			psmt.setInt(1, postId);
			ResultSet rs = psmt.executeQuery();
			while (rs.next()) {
				 int post_Id = rs.getInt(1);
				 String postTitle = rs.getString(2);
				 String postContent = rs.getString(3);
				 String postCode = rs.getString(4);
				 String postPic = rs.getString(5);
				 Timestamp postDate = rs.getTimestamp(6);
				 int postCategory = rs.getInt(7);
				 int postUserId = rs.getInt(8);
				 
				 post= new Post(postId, postTitle, postContent, postCode, postPic, postDate, postCategory, postUserId);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return post;
	}
}
