package com.sunbeam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.pojos.Credentials;
import com.sunbeam.pojos.User;
import com.sunbeam.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String index() {
		return "index";	
	}
	
	@RequestMapping("/login")
	public String authenticateUser(Credentials cr, HttpSession session)
	{
		User user =userService.authenticate(cr);
		if(user!=null) {
			session.setAttribute("curuser", user);
			return "redirect:/allreviews";
		}
		return "failed";
		
	}
	
	@RequestMapping("/register")
	public String newUserRegisteration(Model model) {
		User user = new User();
		model.addAttribute("usr",user);
		return "newuser";
		
	}
	
	public String saveUser(@Valid @ModelAttribute("usr") User user, BindingResult res ) {
		if(res.hasErrors()) {
			System.out.println(res);
			return "newuser";
		}
		else {
			int count = userService.saveUser(user);
		}
		
		return "redirect:/";
		
	}
	
}
