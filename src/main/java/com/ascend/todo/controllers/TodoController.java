package com.ascend.todo.controllers;


import com.ascend.todo.entities.User;
import com.ascend.todo.services.TodoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by BiG on 5/27/2017 AD.
 */

@RestController
@RequestMapping("/api/v1")
public class TodoController {

    private static final Logger log = LoggerFactory.getLogger(TodoController.class);


    private TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping("/users")
    public List<User> getAllUser() {
        log.info("Get all user");
        log.info("--------------");
        return todoService.getAllUser();
    }
}
