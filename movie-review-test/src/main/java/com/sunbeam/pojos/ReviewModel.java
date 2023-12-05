package com.sunbeam.pojos;

import java.util.Date;


public class ReviewModel {
	private int id;
	private int movieId;	
	private int userId;
	private String review;
	private int rating;
	private Date modified;
	
	public ReviewModel() {
		this(0, 0, 0, "", 0, new Date());
	}

	public ReviewModel(int id, int movieId, int userId, String review, int rating, Date modified) {
		this.id = id;
		this.movieId = movieId;
		this.userId = userId;
		this.review = review;
		this.rating = rating;
		this.modified = modified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", movieId=" + movieId + ", userId=" + userId + ", review=" + review + ", rating="
				+ rating + ", modified=" + modified + "]";
	}
}
