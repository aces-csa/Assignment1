package userlogin.dao;

import userlogin.exceptions.UserNotFoudException;
import userlogin.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import  java.sql.* ;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl  implements UserDao{
	
	
	
	Connection conn  ; 

	@Override
	public User getUser(String username, String pass)  {
		
		try {  

        String  url="jdbc:postgresql://localhost:5432/assignment1";
            conn = DriverManager.getConnection(url , "postgres" , "postgres");
             
            PreparedStatement statement = conn. prepareStatement("select * from appusers where username = ? and password = ?");
             statement.setString(1 , username);
             statement.setString(2 , pass);
             ResultSet rs = statement.executeQuery() ;
             if(rs.next()){
                 User user = new User() ;
                 user.setFullname(rs.getString(1));
                 user.setUsername(rs.getString(2));

                 user.setDateofBirth(rs.getDate(3).toLocalDate());
                 user.setPassword(rs.getString(4));
                 return user ;


             }else {
                 throw new UserNotFoudException() ;
             }



            }
        catch (UserNotFoudException unf){
            System.out.println(unf);
        }
            catch (Exception e) {  
            System.out.println(e.toString());  
        }  
		 
		return  null ;
	}


    @Override
    public void setUser(User user) {

        try {

            String  url="jdbc:postgresql://localhost:5432/assignment1";
            conn = DriverManager.getConnection(url , "postgres" , "postgres");



            try{

                 PreparedStatement pr = conn.prepareStatement("select * from appusers where username = ?");
                 pr.setString(1 , user.getUsername());
                 ResultSet rs =  pr.executeQuery() ;
                 if( rs.next())
                 {
                     System.out.println("user with username already exits !!!!!!");
                     return ;
                 }

            }
            catch (Exception e ){
                System.out.println(e.fillInStackTrace());
            }

            PreparedStatement statement = conn. prepareStatement("insert into appusers(fullname ,username , dateofbirth,password) values(?,?,?,?)");
            statement.setString(1, user.getFullname());
            statement.setString(2 , user.getUsername());
            statement.setDate(3 , Date.valueOf(user.getDateofBirth()));
            statement.setString(4 , user.getPassword());

            int res = statement.executeUpdate() ;
            if( res==1 ){
                System.out.println("user created");
            }




        }
        catch (Exception e) {
            System.out.println(e.toString());
        }



    }

    @Override
    public List<User> getAllUsers() {
        List<User> users  = new ArrayList<User>( );
        try {

            String  url="jdbc:postgresql://localhost:5432/assignment1";
            conn = DriverManager.getConnection(url , "postgres" , "postgres");

            PreparedStatement statement = conn. prepareStatement("select * from appusers ;");

            ResultSet rs = statement.executeQuery() ;
            while(rs.next()) {
                User user = new User();
                user.setFullname(rs.getString(1));
                user.setUsername(rs.getString(2));

                user.setDateofBirth(rs.getDate(3).toLocalDate());
                user.setPassword(rs.getString(4));
                users.add(user);


            }



        }

        catch (Exception e) {
            System.out.println(e.toString());
        }
        return users ;
    }

    @Override
    public void deleteUser(String username) {


        try
        {
            String  url="jdbc:postgresql://localhost:5432/assignment1";
            conn = DriverManager.getConnection(url , "postgres" , "postgres");

            PreparedStatement statement = conn. prepareStatement("select * from appusers where username =? ;");
            statement.setString(1 , username );
            ResultSet rs = statement.executeQuery() ;

            if(!rs.next()){
                throw new UserNotFoudException()  ;
            }
            else{
                statement = conn.prepareStatement("delete from appusers where username = ? ");
                statement.setString(1, username);
                int res = statement.executeUpdate() ;
                if( res >  0 ){
                    System.out.println("user delted successfully!!!!!!!!!!! ");
                }
                else {
                    System.out.println("zero users affected");
                }

            }

        }
        catch (UserNotFoudException usf){
            System.out.println(usf);
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
