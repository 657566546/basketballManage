package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    public UserMapper userMapper;

    public List<User> findAll(){
        return userMapper.findAll();
    }

    public int save(User user){
        if(user.getId() != 0){//没有id，则为新增，反正为更新
            return userMapper.insert(user);
        }else{
            return userMapper.update(user);
        }
    }

    public int delete(Integer id){
        if(id != 0){
            return userMapper.delete(id);
        }else{
            return 0;
        }
    }

    public List<User> findByPage(Integer pageNum,Integer pageSize){
        return userMapper.findByPage(pageNum,pageSize);
    }
    public Integer selectTotal(){
        return userMapper.selectTotal();
    }
}
