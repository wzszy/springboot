package com.wzszy.controller;

import com.wzszy.domain.User;
import com.wzszy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("findAll")
    public List<User> findUserList() {
        List<User> list = userMapper.findUserList();
        return list;
    }


}
