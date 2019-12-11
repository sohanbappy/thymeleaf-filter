package com.thyme.thymepagination.dao;


import com.thyme.thymepagination.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UserDao extends JpaRepository<User, Integer> {

    }

