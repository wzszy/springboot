package com.wzszy.repository;

import com.wzszy.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User>{


    public List<User> findAllByUsernameLike(String username);

}
