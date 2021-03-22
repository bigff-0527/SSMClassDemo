package cn.bigff.dao;

import cn.bigff.domain.UserPO;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface UserMapper {
    List<UserPO> selectUserList();

    int insertUser(UserPO userPO);
}
