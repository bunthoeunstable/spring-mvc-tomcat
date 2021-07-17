package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.dto.UserDTO;

public interface UserDao {

  int register(UserDTO user);
  
  List<UserDTO> list();
  
  boolean delete(int id);
  
  public UserDTO findUserInfo(String userName);
  
  // [USER,AMIN,..]
  public List<String> getUserRoles(String userName);
}
