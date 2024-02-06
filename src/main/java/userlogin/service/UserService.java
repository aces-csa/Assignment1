package userlogin.service;


import userlogin.model.User;

import java.util.List;


public interface UserService {
	
	public User getuser(String username , String pass) ;

	public  void setUser ( User user ) ;

	public List<User> getAllUsers() ;


	void deleteUser(String username );



	public  User getUserinfo();
}
