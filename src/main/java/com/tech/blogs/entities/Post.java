package com.tech.blogs.entities;

import java.sql.Timestamp;

public class Post
{

	private int postId;
	private String postTitle;
	private String postContent;
	private String postCode;
	private String postPic;
	private Timestamp postDate;
	private int categoryId;
	private int userId;
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getPostTitle() {
		return postTitle;
	}
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
	}
	public String getPostContent() {
		return postContent;
	}
	public void setPostContent(String postContent) {
		this.postContent = postContent;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getPostPic() {
		return postPic;
	}
	public void setPostPic(String postPic) {
		this.postPic = postPic;
	}
	public Timestamp getPostDate() {
		return postDate;
	}
	public void setPostDate(Timestamp postDate) {
		this.postDate = postDate;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Post(int postId, String postTitle, String postContent, String postCode, String postPic, Timestamp postDate,
			int categoryId,int userId) {
		super();
		this.postId = postId;
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postCode = postCode;
		this.postPic = postPic;
		this.postDate = postDate;
		this.categoryId = categoryId;
		this.userId = userId;
	}
	public Post(String postTitle, String postContent, String postCode, String postPic, Timestamp postDate,
			int categoryId,int userId) {
		super();
		this.postTitle = postTitle;
		this.postContent = postContent;
		this.postCode = postCode;
		this.postPic = postPic;
		this.postDate = postDate;
		this.categoryId = categoryId;
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postTitle=" + postTitle + ", postContent=" + postContent + ", postCode="
				+ postCode + ", postPic=" + postPic + ", postDate=" + postDate + ", categoryId=" + categoryId
				+ ", userId=" + userId + "]";
	}
	
	
	
}
