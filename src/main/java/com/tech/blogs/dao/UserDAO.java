package com.tech.blogs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;

import javax.mail.search.FromStringTerm;

import com.tech.blogs.entities.User;
import com.tech.blogs.helper.DBConnection;

public class UserDAO {

	private Connection connection;

	public UserDAO(Connection connection) {
		this.connection = connection;

	}

	// saving user into db

	public boolean saveUser(User user) {
		boolean f = false;

		try {

			connection = DBConnection.getDBConnection();
			String query = "insert into user(name,email,password,gender,about) values(?,?,?,?,?)";
			String queryAbout = "insert into user(name,email,password,gender) values(?,?,?,?)";

			if (user.getAbout() != "" || user.getAbout() != null) {
				PreparedStatement psmt = connection.prepareStatement(query);
				psmt.setString(1, user.getName());
				psmt.setString(2, user.getEmail());
				psmt.setString(3, user.getPassword());
				psmt.setString(4, user.getGender());
				psmt.setString(5, user.getAbout());
				psmt.executeUpdate();
				f = true;
			}

			else {
				PreparedStatement psmtAbout = connection.prepareStatement(queryAbout);
				psmtAbout.setString(1, user.getName());
				psmtAbout.setString(2, user.getEmail());
				psmtAbout.setString(3, user.getPassword());
				psmtAbout.setString(4, user.getGender());
				psmtAbout.executeUpdate();
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public User getUserByEmailAndPassword(String email, String Password) {
		User user = null;
		String userEmail = "'" + email + "'";
		String userPassword = "'" + Password + "'";
		try {
			String queryString = "select * From user where email=" + userEmail + " " + "and" + " " + "password="
					+ userPassword;
			System.out.println(queryString);
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(queryString);
			while (rs.next()) {
				int userId = rs.getInt(1);
				String name = rs.getString(2);
				String email1 = rs.getString(3);
				String password = rs.getString(4);
				String gender = rs.getString(5);
				String aboutUser = rs.getString(6);
				Timestamp regDate = rs.getTimestamp(7);
				String usrProfile = rs.getString(8);
				user=new User();
				user.setId(userId);
				user.setName(name);
				user.setEmail(email1);
				user.setPassword(password);
				user.setGender(gender);
				user.setAbout(aboutUser);
				user.setDateTimestamp(regDate);
				user.setProfilePic(usrProfile);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public boolean updateUser(User user)
	{
		boolean updateUserStatus = false;
		try {
			
			String query = "update user set name=?,email=?,gender=?,about=?,profile=? where id=?";
			PreparedStatement psmt  = connection.prepareStatement(query);
			psmt.setString(1, user.getName());
			psmt.setString(2, user.getEmail());
			psmt.setString(3, user.getGender());
			psmt.setString(4, user.getAbout());
			psmt.setString(5, user.getProfilePic());
			psmt.setInt(6, user.getId());
			
			int executeUpdate = psmt.executeUpdate();
			updateUserStatus=true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return updateUserStatus;
	}

}
