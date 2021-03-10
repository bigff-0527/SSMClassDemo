package cn.bigff.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {

//    private Long userId;

    private String username;

    private String password;

    private int age;

    public  UserPO(String username,int age){
        this.username = username;
        this.age = age;
    }


}
