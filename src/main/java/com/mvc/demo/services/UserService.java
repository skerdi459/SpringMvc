package com.mvc.demo.services;

import com.mvc.demo.models.Users;
import com.mvc.demo.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService { 
    @Autowired
    UserRepository userRepo;

    public List<Users> getUsers(){
        return (List<Users>) userRepo.findAll();
    }

    public Users getUser(){
        List<Users> list= (List<Users>) userRepo.findAll();
        return  list.get(0);
    }

}
