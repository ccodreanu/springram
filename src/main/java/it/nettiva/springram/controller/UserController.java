package it.nettiva.springram.controller;

import it.nettiva.springram.model.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import it.nettiva.springram.model.User;
import it.nettiva.springram.repository.UserRepository;

import java.util.HashSet;

@Controller
public class UserController {
  @Autowired
  private UserRepository userRepository;


  @GetMapping("/register")
  public String registerForm(Model model) {
    model.addAttribute("registerForm", new User());

    return "register";
  }

  @PostMapping("/register")
  public String registerUser(@ModelAttribute("registerForm") User user) {
    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

    userRepository.save(user);

    return "redirect:/login";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/")
  public String hello(Model model) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();

    model.addAttribute("username", auth.getName());

    return "dashboard";
  }

  @GetMapping("/{username}")
  @ResponseBody
  public String dash(@PathVariable String username) {
    return username;
  }
}