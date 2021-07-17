package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.UserDao;
import com.springmvc.model.UserInfo;
import com.springmvc.model.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserDao userDao;

	public int register(UserDTO user) {
		return userDao.register(user);
	}

	public List<UserDTO> list() {
		return userDao.list();
	}

	@Override
	public boolean delete(int id) {
		return userDao.delete(id);
	}

	@Override
	public UserInfo findUserInfo(String username) {
		
		UserDTO userDTO = userDao.findUserInfo(username);
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName(userDTO.getUsername());
		userInfo.setPassword(userDTO.getPassword());
		return userInfo;
	}

	@Override
	public List<String> getUserRoles(String username) {
		return userDao.getUserRoles(username);
	}

  
  
}
