package userlogin.util;

public interface QueryMapper {


    public static  String query1 =  "select * from appusers where username = ?" ;

    public static String query2 =  "insert into appusers(fullname ,username , dateofbirth,password) values(?,?,?,?)";
    public static String query3=  "select * from appusers ;";
    public static String query4=  "select * from appusers where username = ? and password = ?";
    public static String query5=  "select * from appusers where username = ? ; " ;
    public static String query6=  "delete from appusers where username = ? " ;




}


