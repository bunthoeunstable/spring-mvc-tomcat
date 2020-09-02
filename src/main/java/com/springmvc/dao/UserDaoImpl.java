package com.springmvc.dao;

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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.springmvc.model.Login;
import com.springmvc.model.User;
import com.springmvc.persistence.HibernateUtil;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

//  @Autowired
//  SessionFactory session;



  public int register(User user) {
	  
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

  public User validateUser(Login login) {
	  
    String sql = "From User where username='" + login.getUsername() + "' OR email = '"+ login.getUsername() +"' AND password='" + login.getPassword() + "'";
    
//    List<User> users = session.getCurrentSession().createQuery(sql).list();
    @SuppressWarnings("unchecked")
	List<User> users =  HibernateUtil.getSession().createQuery(sql).list();

    return users.size() > 0 ? users.get(0) : null;
  }
    
  
	@SuppressWarnings("unchecked")
	public List<User> list() {
	
	   //return (List<User>)session.getCurrentSession().createQuery("from User").list();
	   return  (List<User>)HibernateUtil.getSession().createQuery("FROM User").list();
    }

	public boolean delete(int id) {
		try{
			 Transaction transaction = null;
			 Session session = null;
			 try {
				 Query query  = HibernateUtil.getSession().createQuery("FROM User WHERE id = :id");
				 query.setParameter("id", id);
				 User user = (User)query.list().get(0);
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

}

//
//
//class UserMapper implements RowMapper<User> {
//
//  public User mapRow(ResultSet rs, int arg1) throws SQLException {
//    User user = new User();
//
//    user.setUsername(rs.getString("username"));
//    user.setPassword(rs.getString("password"));
//    user.setFirstname(rs.getString("firstname"));
//    user.setLastname(rs.getString("lastname"));
//    user.setEmail(rs.getString("email"));
//    user.setAddress(rs.getString("address"));
//    user.setPhone(rs.getString("phone"));
//
//    return user;
//  }
//}