package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    List<User> getAllUserInfo();

    Page<User> getUserInfoByName(Pageable p, String name);

    User findUserById(Integer id);

    Boolean updateUserById(String name, Integer age, Integer id);

    Boolean addUserinfo(String name, Integer age);

    Boolean deleteUserById(Integer id);

    Page<User> getAllPageUserInfo(Pageable pageable);
}
