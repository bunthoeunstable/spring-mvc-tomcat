package com.springmvc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.springmvc.dao.UserDao;
import com.springmvc.mapper.UserInfoMapper;
import com.springmvc.model.UserInfo;
import com.springmvc.model.dto.UserDTO;
import com.springmvc.persistence.HibernateUtil;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

//  @Autowired
//  SessionFactory session;



  public int register(UserDTO user) {
	  
	 System.out.println("list users => "+new Gson().toJson(user));
	 
	 Transaction transaction = null;
	 Session session = null;
	 try {
		 session = HibernateUtil.getSession();
	     transaction = session.beginTransaction();
	     session.save(user);
		 transaction.commit();
	 }catch(HibernateException e) {
		 e.getStackTrace();
	 }
//	 session.getCurrentSession().saveOrUpdate(user);
	 return 1;
  }


  
	@SuppressWarnings("unchecked")
	public List<UserDTO> list() {
		
	   return  (List<UserDTO>)HibernateUtil.getSession().createQuery("FROM UserDTO").list();
    }

	public boolean delete(int id) {
		try{
			 Transaction transaction = null;
			 Session session = null;
			 try {
				 Query query  = HibernateUtil.getSession().createQuery("FROM UserDTO WHERE id = :id");
				 query.setParameter("id", id);
				 UserDTO user = (UserDTO)query.list().get(0);
				 session = HibernateUtil.getSession();
			     transaction = session.beginTransaction();
			     session.delete(user);
				 transaction.commit();
			 }catch(Exception e) {
				 e.getStackTrace();
			 }
//			session.getCurrentSession().delete(user);
		}catch(Exception ex){
			return false;
		}	
		return true;
	}	

    @Override
    public UserDTO findUserInfo(String userName) {

		UserDTO user = null;
		try {
			Query query = HibernateUtil.getSession().createQuery("FROM UserDTO u where u.username = :username");
			query.setParameter("username", userName);
			user = (UserDTO) query.list().get(0);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return user;
    }
 
    @Override
    public List<String> getUserRoles(String userName) {
       
    	List<String> roles = null; 
    	try {
			Query query = HibernateUtil.getSession().createQuery("SELECT ur.role FROM UserRoleDTO ur where ur.username = :username");
			query.setParameter("username", userName);
		    roles  = (List<String>) query.list();
		} catch (Exception e) {
			e.getStackTrace();
		}
         
        return roles;
    }
     
}