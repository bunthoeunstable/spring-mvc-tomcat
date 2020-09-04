package com.springmvc.controller;

import com.springmvc.model.User;
import com.springmvc.service.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<User>> users(HttpServletRequest request){
        List<User> users = userService.list();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);

    }
}
