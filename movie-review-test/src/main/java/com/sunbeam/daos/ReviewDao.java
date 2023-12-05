package com.sunbeam.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.pojos.Review;



public interface ReviewDao extends JpaRepository<Review, Integer> {

	List<Review> findByUserId(int userId);
}
