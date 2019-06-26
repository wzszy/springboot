package com.wzszy.mapper;

import com.wzszy.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    public List<User> findUserList();
}