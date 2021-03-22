package cn.bigff.service;

import cn.bigff.domain.UserPO;

import java.util.List;


public interface IUserService {
    List<UserPO> selectUserList();
    int insertUser(UserPO userPO);
}
