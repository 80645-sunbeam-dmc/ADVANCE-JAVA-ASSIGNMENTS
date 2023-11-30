package com.sunbeam.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunbeam.daos.MovieDao;
import com.sunbeam.pojos.Movie;

/**
 * Advanced Java @ DMC Sep 2023
 * Trainer: Nilesh Ghule
 * Time: 2023-11-29 17:43 
 */
@Controller
public class TestReviewController {
	@Autowired
	private MovieDao movieDao;
	
	@GetMapping("/basicmovies")
	public @ResponseBody List<Movie> getMovies() {
		List<Movie> list = movieDao.findAll();
		return list;
	}
}



