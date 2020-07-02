package cn.ssm.service;

import cn.ssm.dao.UserMapper;
import cn.ssm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public List<User> getAll(){
        return userMapper.selectByExample(null);
    }
    public User getUser(User u){
        return userMapper.selectByPrimaryKey(u.getEmail());
    }
    public void InsertUser(User u){
        userMapper.insert(u);
    }
}
