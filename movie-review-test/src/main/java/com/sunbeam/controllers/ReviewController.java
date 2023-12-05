package com.sunbeam.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.css.CSSUnknownRule;

import com.sunbeam.pojos.Movie;
import com.sunbeam.pojos.Review;
import com.sunbeam.pojos.ReviewModel;
import com.sunbeam.pojos.User;
import com.sunbeam.services.MovieService;
import com.sunbeam.services.ReviewService;

/**
 * Advanced Java @ DMC Sep 2023
 * Trainer: Nilesh Ghule
 * Time: 2023-11-28 16:57 
 */
@Controller
public class ReviewController {
	@Autowired
	private ReviewService reviewService;
	@Autowired
	private MovieService movieService;
	
	@RequestMapping("/allreviews")
	public String getAllReviews(Model model) {
		List<Review> list = reviewService.findAllReviews();
		model.addAttribute("reviewList", list);
		model.addAttribute("title", "All Reviews");
		return "reviews";
	}

	@RequestMapping("/myreviews")
	public String getMyReviews(Model model, HttpSession session) {
		User user = (User) session.getAttribute("curUser");
		int userId = user.getId(); //get user id of current user
		List<Review> list = reviewService.findReviewsByUserId(userId);
		model.addAttribute("reviewList", list);
		model.addAttribute("title", "My Reviews");
		return "reviews";
	}
	
	@RequestMapping("/newreview")
	public String newReview(Model model) {
		List<Movie> list = movieService.findAllMovies();
		model.addAttribute("movieList", list);
		return "addreview";
	}
	
	@RequestMapping("/savereview")
	public String saveReview(ReviewModel review, HttpSession session) {
		User user = (User) session.getAttribute("curUser");
		review.setUserId( user.getId() );
		int count = reviewService.saveReview(review);
		return "redirect:/allreviews";
	}
	
	@RequestMapping("/delreview")
	public String deleteReview(@RequestParam("id") int reviewId) {
		int count = reviewService.deleteReviewById(reviewId);
		return "redirect:/allreviews";
	}
}












