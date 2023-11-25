package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface UserMapper {
    List<User> findAll();
    @Insert("insert into dt_pro.db_user(id,userName) values(#{id}, #{userName})")
    int insert(User user);

    int update(User user);

    int delete(Integer id);

    List<User> findByPage(Integer pageNum,Integer pageSize);

    int selectTotal();
}
