package com.tech.blogs.entities;

import java.sql.Timestamp;

public class User {

	
	private int id;
	private String name;
	private String email;
	private String password;
	private String gender;
	private String about="Hey there I am isng technical blogs";
	private Timestamp dateTimestamp;
	private String profilePic;
	public User(int id, String name, String email, String password, String gender, String about,
			Timestamp dateTimestamp) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.about = about;
		this.dateTimestamp = dateTimestamp;
	}
	public User() {
		 
	}
	public User(String name, String email, String password, String gender, String about ) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.about = about;
		
	}
	
	public User(String userName, String userEmail, String userPassword, String userGender) {
		super();
		this.name = userName;
		this.email = userEmail;
		this.password = userPassword;
		this.gender = userGender;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public Timestamp getDateTimestamp() {
		return dateTimestamp;
	}
	public void setDateTimestamp(Timestamp dateTimestamp) {
		this.dateTimestamp = dateTimestamp;
	}
	
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", gender="
				+ gender + ", about=" + about + ", dateTimestamp=" + dateTimestamp + "]";
	}
	
	 
	
	
}
