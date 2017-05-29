package com.ascend.todo.exceptions;

/**
 * Created by BiG on 5/28/2017 AD.
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
