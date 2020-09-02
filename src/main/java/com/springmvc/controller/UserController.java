package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.google.gson.Gson;
import com.springmvc.model.User;
import com.springmvc.service.UserService;

@Controller
public class UserController {

	  @Autowired
	  public UserService userService;
	 
	  @RequestMapping(value = "/users", method = RequestMethod.GET)
	  public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView mav = new ModelAndView("users");
	    System.out.println("list users => "+new Gson().toJson(userService.list()));
	    mav.addObject("list", userService.list());

	    return mav;
	  }
	  
	  @RequestMapping(value = "/users/{id}/delete", method = RequestMethod.POST)
	  public RedirectView index(@PathVariable("id") int id, HttpServletRequest request, HttpServletResponse response) {
	    userService.delete(id);;
	    return new RedirectView("/users/");
	  }
}
