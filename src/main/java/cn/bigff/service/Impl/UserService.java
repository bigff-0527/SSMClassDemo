package cn.bigff.service.Impl;

import cn.bigff.dao.UserMapper;
import cn.bigff.domain.UserPO;
import cn.bigff.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService  implements IUserService {

    @Autowired
    private UserMapper userMapper ;



    @Override
    public List<UserPO> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public int insertUser(UserPO userPO) {
        return userMapper.insertUser(userPO);
    }
}
