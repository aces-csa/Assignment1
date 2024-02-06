package userlogin.Main;

import userlogin.model.User;
import userlogin.service.UserService;
import userlogin.service.UserServiceImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;





public class Driver {


	private static UserService userService  = new UserServiceImpl() ;


	public static void main(String[] args) {


		System.out.println("Enter 1 create user , 2 to login , 3 to delete user  and 4 to list all the users");
		Scanner sc =  new Scanner (System.in) ;
		int input = sc.nextInt() ;

		while(input!=-1 ){



			switch (input){
				case 1 :
					System.out.println("enter user info");
					User user = userService.getUserinfo ( ) ;
					userService.setUser(user);
					break ;
				case 2 :
					System.out.println("enter username and pass");
					System.out.println("enter username : ");

					String username = sc.next() ;
					System.out.println("enter password ");

					String password  =  sc .next() ;

					userService.getuser(username , password) ;
					break ;
				case 3  :

					System.out.println("enter username to delete  the user");
					String uname  = sc.next() ;
					userService.deleteUser(uname) ;
					break ;

				case 4 :
					System.out.println("listing out all the users ");
					List<User> users =  userService.getAllUsers() ;

					System.out.println(users);
					break ;


			}
			System.out.println("Enter 1 create user , 2 to login , 3 to delete user  and 4 to list all the users");
             input = sc.nextInt() ;


		 
		 
		 
		 
		 
	}
}


	}
