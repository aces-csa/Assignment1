package userlogin.dao;

import userlogin.model.User;

import java.util.List;


public interface UserDao {
	
 public User getUser(String username  , String pass) ;

 public void setUser(User user) ;


 public List<User> getAllUsers( ) ;

 public  void deleteUser(String username)  ;


}
