package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;
    @GetMapping
    public List<User> fidAll(){
        return userService.findAll();
    }

    @PostMapping("/save")
    public Integer save(@RequestBody User user){
        return userService.save(user);
    }
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return userService.delete(id);
    }

    //分页查询
    //接口路径:/user/all
    //@RequestParam 接受 pageNum=1&pageSize=10
    @GetMapping("/all")
    public Map<String,Object> index(@RequestParam Integer pageNum, Integer pageSize){
        pageNum = (pageNum - 1) * pageSize;
        List<User> data = userService.findByPage(pageNum,pageSize);
        Integer pageTotal = userService.selectTotal();
        Map<String,Object> result = new HashMap<>();
        result.put("data",data);
        result.put("result",pageTotal);
        return result;
    }
}
