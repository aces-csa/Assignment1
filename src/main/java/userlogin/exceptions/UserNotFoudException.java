package userlogin.exceptions;

import org.w3c.dom.ls.LSOutput;

public class UserNotFoudException extends  Exception {


    @Override
    public String toString() {
        System.out.println("this is user not found exception" );
        return super.toString();
    }
}
