package com.sunbeam.pojos;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Review {
	
	@Id
	private int id;
	private String review;
	private int rating;
	private Date modified;

	@ManyToOne
	@JoinColumn(name="movie_id")
	private Movie movie;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Review(int id, String review, int rating, Date modified) {
		super();
		this.id = id;
		this.review = review;
		this.rating = rating;
		this.modified = modified;
	}

	public Review() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", review=" + review + ", rating=" + rating + ", modified=" + modified + "]";
	}
	
	
}
