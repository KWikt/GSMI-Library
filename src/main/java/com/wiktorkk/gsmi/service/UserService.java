package com.wiktorkk.gsmi.service;

import com.wiktorkk.gsmi.dao.UserDao;
import com.wiktorkk.gsmi.dto.LoginRequest;
import com.wiktorkk.gsmi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;


    public boolean findByEmail(String email) {
        return userDao.findByEmail(email) != null;
    }

    public boolean authenticate(LoginRequest loginRequest) {
       User userInDao =  userDao.findByUsername(loginRequest.getUsername());
       if (userInDao == null) {
           return false;
       }

       if (loginRequest.getPassword().equals(userInDao.getPassword())) {
           return true;
       }

       return false;
    }

    public void save(User user) {
        userDao.save(user);
    }
}
