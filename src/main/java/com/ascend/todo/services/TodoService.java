package com.ascend.todo.services;

import com.ascend.todo.entities.User;
import com.ascend.todo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by BiG on 5/27/2017 AD.
 */
@Service
public class TodoService {
    private UserRepo userRepo;

    @Autowired
    public TodoService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    public User createUser(User user) {
        return userRepo.saveAndFlush(user);
    }
}
