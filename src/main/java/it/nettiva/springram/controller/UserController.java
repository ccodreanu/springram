package it.nettiva.springram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.nettiva.springram.model.User;
import it.nettiva.springram.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/protected", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "this should be protected";
	}
	
	@RequestMapping(value = "/public", method = RequestMethod.GET)
	@ResponseBody
	public String say() {
		User u = new User();
		u.setUsername("cata");
		u.setPassword(new BCryptPasswordEncoder().encode("password"));
		
		userRepository.save(u);
		
		return "this should be public";
	}
}