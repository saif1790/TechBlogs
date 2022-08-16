package com.tech.blogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LikeDAO {

	Connection connection;

	public LikeDAO(Connection connection) {
		super();
		this.connection = connection;
	}

	public boolean insertLikesOnPost(int postId, int userId) {
		boolean likesOnPost = false;
		String inserLikesOnPostQuery = "insert into likes(post_Id,user_Id) values(?,?)";

		try {

			PreparedStatement psmt = connection.prepareStatement(inserLikesOnPostQuery);
			psmt.setInt(1, postId);
			psmt.setInt(2, userId);
			int executeUpdate = psmt.executeUpdate();
			if (executeUpdate == 1)
				likesOnPost = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return likesOnPost;
	}

	public int countLikesOnPost(int postId) {
		int postLikesCount = 0;
		String getLikesOnPostQuery = "select count(*) from likes where post_Id=?";

		try {

			PreparedStatement psmt = connection.prepareStatement(getLikesOnPostQuery);
			psmt.setInt(1, postId);
			ResultSet rs = psmt.executeQuery();

			while (rs.next()) {

				postLikesCount = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return postLikesCount;
	}

	public boolean isLikeByUser(int postId, int userId) {
		boolean isLike = false;
		String isLikePostQuery = "select * from likes where post_Id=? and user_Id=?";

		try {

			PreparedStatement psmt = connection.prepareStatement(isLikePostQuery);
			psmt.setInt(1, postId);
			psmt.setInt(2, userId);
			ResultSet rs = psmt.executeQuery();
			if (rs.next()) {
				isLike = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return isLike;
	}
	
	public boolean deleteLike(int postId, int userId)
	{
		boolean isDeleteLike = false;
		String deleteLikeQuery = "delete from likes where post_Id=? and user_Id=";
		
		try {
			PreparedStatement psmt = connection.prepareStatement(deleteLikeQuery);
			psmt.setInt(1, postId);
			psmt.setInt(2, userId);
			psmt.executeUpdate();
			isDeleteLike=true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return isDeleteLike;
	}
}
