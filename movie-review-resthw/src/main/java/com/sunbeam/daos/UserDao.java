package com.sunbeam.daos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sunbeam.pojos.User;

/**
 * Advanced Java @ DMC Sep 2023
 * Trainer: Nilesh Ghule
 * Time: 2023-11-28 15:29 
 */
@Repository
public class UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private UserRowMapper userRowMapper;
	
	public User findByEmail(String email) {
		String sql = "SELECT * FROM users WHERE email=?";
		List<User> list = jdbcTemplate.query(sql, userRowMapper, email);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public int save(User u) {
		String sql = "INSERT INTO users(id, first_name, last_name, email, mobile, birth, password) VALUES(default, ?, ?, ?, ?, ?, ?)";
		int count = jdbcTemplate.update(sql, u.getFirstName(), u.getLastName(), u.getEmail(), u.getMobile(), u.getBirth(), u.getPassword());
		return count;
	}
}





