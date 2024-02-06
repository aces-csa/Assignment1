package userlogin.dao;

import userlogin.exceptions.UserNotFoudException;
import userlogin.model.User;
import userlogin.util.DatabaseInitializer;
import userlogin.util.QueryMapper;

import javax.management.Query;
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

            conn= DatabaseInitializer.getconnection() ;
             
            PreparedStatement statement = conn. prepareStatement(QueryMapper.query4);
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


    private  boolean getUser(String username){
        try{
            conn =  DatabaseInitializer.getconnection() ;



            PreparedStatement statement = conn. prepareStatement(QueryMapper.query5);
            statement.setString(1 , username);

            ResultSet rs = statement.executeQuery() ;
           if( rs.next())
               return  true ;



        }
        catch ( Exception e) {
            System.out.println(e);
        }

        return  false ;
    }

    @Override
    public void setUser(User user) {

        try {

            conn= DatabaseInitializer.getconnection() ;



                   if(getUser(user.getUsername())){
                       System.out.println("user found with same username !!! \n change the username and try again ");
                       return   ;
                   }


            PreparedStatement statement = conn. prepareStatement(QueryMapper.query2);
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

             conn= DatabaseInitializer.getconnection() ;

            PreparedStatement statement = conn. prepareStatement(QueryMapper.query3);

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
            conn = DatabaseInitializer.getconnection() ;

            PreparedStatement statement = conn. prepareStatement(QueryMapper.query5);
            statement.setString(1 , username );
            ResultSet rs = statement.executeQuery() ;

            if(!rs.next()){
                throw new UserNotFoudException()  ;
            }
            else{
                statement = conn.prepareStatement(QueryMapper.query6);
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
