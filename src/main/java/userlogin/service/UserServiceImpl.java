package userlogin.service;

import userlogin.dao.UserDao;
import userlogin.dao.UserDaoImpl;
import userlogin.model.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class UserServiceImpl  implements UserService{

	UserDao userDao = new UserDaoImpl() ;
	@Override
	public User getuser(String username, String pass) {
		
		
		
		return userDao.getUser(username,  pass) ;
	}

	@Override
	public void setUser(User user) {
		   userDao.setUser(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers() ;
	}

	@Override
	public void deleteUser(String username) {
		 userDao.deleteUser(username);
	}


	@Override
	public User getUserinfo() {
		Scanner sc = new Scanner( System.in ) ;
		User user = new User() ;


		System.out.println("enter fullname ");
		user.setFullname(sc.next());
		System.out.println("enter username");
		user.setUsername(sc.next());
		System.out.println("enter dob (yyyy-MM-dd)");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		user.setDateofBirth(LocalDate.parse(sc.next() , formatter));
		System.out.println("enter password");
		user.setPassword(sc.next());
		return user ;

	}


}
