package com.springmvc.service;

import java.util.List;

import com.springmvc.model.UserInfo;
import com.springmvc.model.dto.UserDTO;

public interface UserService {

	int register(UserDTO user);

	List<UserDTO> list();

	boolean delete(int id);

	UserInfo findUserInfo(String username);

	List<String> getUserRoles(String username);
}
