package com.sunbeam.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.pojos.Movie;

public interface MovieDao extends JpaRepository<Movie ,Integer>{

	
}
