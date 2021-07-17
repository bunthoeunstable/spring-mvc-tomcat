package com.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.springmvc.model.dto.UserDTO;
import com.springmvc.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {
	
  @Autowired
  public UserService userService;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public String showRegister(HttpServletRequest request, HttpServletResponse response, Model model) {
  
	model.addAttribute("user", new UserDTO());
    return "registerPage";
  }

  @RequestMapping(value = "/registerProcess", method = RequestMethod.POST)
  public RedirectView addUser(HttpServletRequest request, HttpServletResponse response,
      @ModelAttribute("user") UserDTO user) {

	  userService.register(user);
	  
	  return new RedirectView("/admin");
  }
  
  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public String index(HttpServletRequest request, HttpServletResponse response, Model model) {

	List<UserDTO> list = userService.list();
    System.out.println("list users => "+new Gson().toJson(list));
    model.addAttribute("list", list);
    return "usersPage";
  }
  
  @RequestMapping(value = "/user/{id}/delete", method = RequestMethod.POST)
  public RedirectView index(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
    userService.delete(id);;
    return new RedirectView("/admin");
  }
}
