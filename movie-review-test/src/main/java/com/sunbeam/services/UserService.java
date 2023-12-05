package com.sunbeam.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDao;
import com.sunbeam.pojos.Credentials;
import com.sunbeam.pojos.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public User authenticate(Credentials cr) {
		User user =userDao.findByEmail(cr.getEmail());
		if(user !=null && user.getPassword().equals(cr.getPasswd()))
			return user;
		return null;
	}
	
	public int saveUser(User user) {
		User dbUser = userDao.save(user);
		return 1;
	}

}
