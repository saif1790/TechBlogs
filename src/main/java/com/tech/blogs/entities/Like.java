package com.tech.blogs.entities;

public class Like
{

	private int likeId;
	private int postId;
	private int userId;
	
	public Like( ) {
		super();
	}
	
	public Like(int likeId, int postId, int userId) {
		super();
		this.likeId = likeId;
		this.postId = postId;
		this.userId = userId;
	}
	
	public Like(int postId, int userId) {
		super();
		this.postId = postId;
		this.userId = userId;
	}

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "LIke [likeId=" + likeId + ", postId=" + postId + ", userId=" + userId + "]";
	}
	
	
	
}
