package com.thyme.thymepagination.dao;


import com.thyme.thymepagination.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface UserDao extends JpaRepository<User, Integer>{

    Page<User> findAll(Pageable pageable);

    }

