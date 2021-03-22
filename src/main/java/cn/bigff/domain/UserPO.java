package cn.bigff.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserPO {

//    private Long userId;
    private Long id;

    private String username;

    private String password;

    private boolean sex;


    private Date createTime;


}
