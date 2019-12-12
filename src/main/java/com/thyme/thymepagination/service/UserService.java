package com.thyme.thymepagination.service;

import com.thyme.thymepagination.dao.UserDao;
import com.thyme.thymepagination.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User saveUser(User user){
        userDao.save(user);
        return user;
    }

    public List<User> getAllUser(){
        return userDao.findAll();
    }

    public Page<User> getAllUser(PageRequest req){

         Page<User> allUserWithPaging = userDao.findAll(req);
         return allUserWithPaging;

    }

    public void deleteUser(int id){
        userDao.deleteById(id);
    }

}
