package com.sunbeam.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.pojos.Movie;
import com.sunbeam.pojos.Review;

/**
 * Advanced Java @ DMC Sep 2023
 * Trainer: Nilesh Ghule
 * Time: 2023-11-28 16:44 
 */
@Repository
public class ReviewDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private ReviewRowMapper reviewRowMapper;
	
	public List<Review> findAll() {
		String sql = "SELECT * FROM reviews";
		List<Review> list = jdbcTemplate.query(sql, reviewRowMapper);
		return list;
	}

	public List<Review> findByUserId(int userId) {
		String sql = "SELECT * FROM reviews WHERE user_id=?";
		List<Review> list = jdbcTemplate.query(sql, reviewRowMapper, userId);
		return list;
	}

	public Review findById(int reviewId) {
		String sql = "SELECT * FROM reviews WHERE id=?";
		List<Review> list = jdbcTemplate.query(sql, reviewRowMapper, reviewId);
		return list.isEmpty() ? null : list.get(0);
	}

	public int save(Review review) {
		String sql = "INSERT INTO reviews (review,rating,user_id,movie_id,modified) VALUES(?,?,?,?,NOW())";
		int count = jdbcTemplate.update(sql, review.getReview(), review.getRating(), review.getUserId(), review.getMovieId());
		return count;
	}

	public int deleteById(int reviewId) {
		String sql = "DELETE FROM reviews WHERE id=?";
		int count = jdbcTemplate.update(sql, reviewId);
		return count;
	}
	
	public int update(Review m) {
		String sql = "UPDATE reviews SET review=?, rating=? WHERE id=?";
		int count = jdbcTemplate.update(sql, m.getReview(), m.getRating(), m.getId());
		return count;
	}
}













