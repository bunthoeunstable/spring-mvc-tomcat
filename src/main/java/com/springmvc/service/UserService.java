package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Login;
import com.springmvc.model.User;

public interface UserService {

  int register(User user);

  User validateUser(Login login);
  
  List<User> list();
  
  boolean delete(int id);
}
