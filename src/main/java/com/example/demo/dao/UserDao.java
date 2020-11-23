package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserDao extends JpaRepository<User, Integer>{

    Page<User> findAllByNameIsContaining(Pageable p, String name);

    @Query(nativeQuery = true, value = "select * from tb_user_boot where id=?")
    User findUserById(int id);

}
