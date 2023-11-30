package com.sunbeam.daos;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sunbeam.pojos.Movie;

/**
 * Advanced Java @ DMC Sep 2023
 * Trainer: Nilesh Ghule
 * Time: 2023-11-28 18:20 
 */
@Component
public class MovieRowMapper implements RowMapper<Movie> {
	@Override
	public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
		int id = rs.getInt("id");
		String title = rs.getString("title");
		Date relDate = rs.getDate("rel_date");
		Movie m = new Movie(id, title, relDate);
		return m;
	}
}
