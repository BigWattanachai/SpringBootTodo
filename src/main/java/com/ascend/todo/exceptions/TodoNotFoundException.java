package com.ascend.todo.exceptions;

/**
 * Created by BiG on 5/28/2017 AD.
 */
public class TodoNotFoundException extends RuntimeException {
    public TodoNotFoundException(String message) {
        super(message);
    }
}
