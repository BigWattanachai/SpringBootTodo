package com.ascend.todo.controllers;


import com.ascend.todo.entities.User;
import com.ascend.todo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by BiG on 5/27/2017 AD.
 */

@RestController
@RequestMapping("/api/v1")
public class TodoController {
    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/users")
    public List<User> getAllUser() {
        return todoService.getAllUser();
    }

    @PostMapping("/users")
    public User createUser(@Valid @RequestBody User user) {
        return todoService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable(value = "id") Long id, @Valid @RequestBody User user) {
        return todoService.updateUser(id, user);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable(value = "id") Long id) {
        return todoService.getUserById(id);
    }

    @DeleteMapping("/users/{id}")
    public User deleteUserById(@PathVariable(value = "id") Long id) {
        return todoService.deleteUser(id);
    }
}
