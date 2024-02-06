package userlogin.model;

import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString


public class User {

    private  String  Fullname ;
    private  String username ;
    private LocalDate   dateofBirth ;

    private  String password ;



}