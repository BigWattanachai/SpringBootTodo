package com.ascend.todo.services;

import com.ascend.todo.constants.ErrorMsgEnum;
import com.ascend.todo.entities.User;
import com.ascend.todo.exceptions.UserNotFoundException;
import com.ascend.todo.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public User deleteUser(Long id) {
        User user = Optional.ofNullable(userRepo.findOne(id))
                .orElseThrow(() -> new UserNotFoundException(String.format(ErrorMsgEnum.USER_NOT_FOUND.getMsg(), id)));
        userRepo.delete(user);
        return user;
    }

    public User getUserById(Long id) {
        return userRepo.findOne(id);
    }

    public User updateUser(long id, User userUpdate) {
        User user = Optional.ofNullable(userRepo.findOne(id))
                .orElseThrow(() -> new UserNotFoundException(String.format(ErrorMsgEnum.USER_NOT_FOUND.getMsg(), id)));
        user.setFirstName(userUpdate.getFirstName());
        user.setLastName(userUpdate.getLastName());
        user.setEmail(userUpdate.getEmail());
        return userRepo.saveAndFlush(user);
    }
}
