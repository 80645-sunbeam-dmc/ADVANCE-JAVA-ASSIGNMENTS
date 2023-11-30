package com.sunbeam.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.daos.MovieDao;
import com.sunbeam.daos.ReviewDao;
import com.sunbeam.pojos.Movie;
import com.sunbeam.pojos.Review;

/**
 * Advanced Java @ DMC Sep 2023
 * Trainer: Nilesh Ghule
 * Time: 2023-11-29 17:58 
 */
@RestController
public class MoviesReviewController {
	@Autowired
	private MovieDao movieDao;
	
	@Autowired
	private ReviewDao reviewDao;
	
	@GetMapping("/review")
	public Map<String, Object> getreview() {
		Map<String, Object> reply = new HashMap<>();
		try {
			List<Review> list = reviewDao.findAll();
			reply.put("status", "success");
			reply.put("data", list);			
		}
		catch (Exception e) {
			reply.put("status", "error");
			reply.put("error", e.getMessage());			
		}
		return reply;
	}

	@GetMapping("/review/{id}")
	public Map<String, Object> getMovie(@PathVariable("id") int id) {
		Map<String, Object> reply = new HashMap<>();
		try {
			Review m = reviewDao.findById(id);
			reply.put("status", "success");
			reply.put("data", m);			
		}
		catch (Exception e) {
			reply.put("status", "error");
			reply.put("error", e.getMessage());			
		}
		return reply;
	}
	
	/*
	@PostMapping("/movies")
	public int saveMovie(@RequestBody Movie m) {
		try {
			int count = movieDao.save(m);
			return count;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	*/
	@PostMapping("/review")
	public Map<String, Object> saveReview(@RequestBody Review m) {
		Map<String, Object> reply = new HashMap<>();
		try {
			int count = reviewDao.save(m);
			reply.put("status", "success");
			reply.put("rowsAffected", count);
		} catch (Exception e) {
			e.printStackTrace();
			reply.put("status", "error");
			reply.put("rowsAffected", 0);
			reply.put("error", e.getMessage());
		}
		return reply;
	}
	
	@DeleteMapping("/review/{id}")
	public Map<String, Object> deleteMovie(@PathVariable("id") int id) {
		Map<String, Object> reply = new HashMap<>();
		try {
			int count = reviewDao.deleteById(id);
			reply.put("status", "success");
			reply.put("rowsAffected", count);
		} catch (Exception e) {
			e.printStackTrace();
			reply.put("status", "error");
			reply.put("rowsAffected", 0);
			reply.put("error", e.getMessage());
		}
		return reply;		
	}
	
	@PutMapping("/review/{id}")
	public Map<String, Object> updateReview(@PathVariable("id") int id, @RequestBody Review m) {
		m.setId(id);
		Map<String, Object> reply = new HashMap<>();
		try {
			int count = reviewDao.update(m);
			reply.put("status", "success");
			reply.put("rowsAffected", count);
		} catch (Exception e) {
			e.printStackTrace();
			reply.put("status", "error");
			reply.put("rowsAffected", 0);
			reply.put("error", e.getMessage());
		}
		return reply;
	}
	
}








