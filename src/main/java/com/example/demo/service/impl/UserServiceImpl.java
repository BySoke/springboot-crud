package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * Spring自己封装的一套 jdbc
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<User> getAllUserInfo() {
        return userDao.findAll();
    }

    @Override
    public Page<User> getUserInfoByName(Pageable p, String name) {
        return userDao.findAllByNameIsContaining(p, name);
    }

    @Override
    public User findUserById(Integer id) {
        return userDao.findUserById(id);
    }

    @Override
    public Boolean updateUserById(String name, Integer age, Integer id) {
        String sql = "update tb_user_boot set name=?,age=? where id=?";
        int update = jdbcTemplate.update(sql, name, age, id);
        if (update > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean addUserinfo(String name, Integer age) {
        String sql = "insert into tb_user_boot (name,age) values (?,?)";
        int insert = jdbcTemplate.update(sql, name, age);
        if (insert > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        String sql = "delete from tb_user_boot where id=?";
        int delete = jdbcTemplate.update(sql, id);
        if (delete > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Page<User> getAllPageUserInfo(Pageable pageable) {
        return userDao.findAll(pageable);
    }
}
