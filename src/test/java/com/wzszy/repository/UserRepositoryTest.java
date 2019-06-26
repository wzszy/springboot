package com.wzszy.repository;

import com.wzszy.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserRepository() {
        List<User> users = userRepository.findAll();
        for (User user : users) {
            System.out.println(user);
        }

    }

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void testFindUserByusername() {
        List<User> users = userRepository.findAllByUsernameLike("%an%");
        redisTemplate.boundHashOps("userList").put("users", users);
        List<User> list = (List<User>) redisTemplate.boundHashOps("userList").get("users");
        for (User user : list) {
            System.out.println(user);
        }
    }


}