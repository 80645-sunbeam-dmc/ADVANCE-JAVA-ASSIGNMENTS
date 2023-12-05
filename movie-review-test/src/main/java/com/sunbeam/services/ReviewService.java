package com.sunbeam.services;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.ReviewDao;
import com.sunbeam.pojos.Movie;
import com.sunbeam.pojos.Review;
import com.sunbeam.pojos.ReviewModel;
import com.sunbeam.pojos.User;

@Service
public class ReviewService {
	@Autowired
	private ReviewDao reviewDao;
	
	public List<Review> findAllReviews(){
		List<Review> list = reviewDao.findAll();
		return list;
	}
	
	public List<Review> findReviewsByUserId(int userId){
		List<Review> list =reviewDao.findByUserId(userId);
		return list;
		
	}
	
	public Review findReviewById(int reviewId) {
		Optional<Review> reviewOpt = reviewDao.findById(reviewId);
		return reviewOpt.orElse(null);
		}
	
	public int saveReview(ReviewModel rm) {
		Review review = new Review (0, rm.getReview(), rm.getRating(), (Date) new java.util.Date());
		review.setMovie(new Movie(rm.getMovieId(),null, null));
		review.setUser(new User(rm.getUserId(),null, null,null,null,null,null));
		Review dbReview =reviewDao.save(review);
		System.out.println("Saved: " + dbReview);
		return 1;
		
	}
	
	public int deleteReviewById(int reviewId) {
		reviewDao.deleteById(reviewId);
		return 1;
		
	}
}
