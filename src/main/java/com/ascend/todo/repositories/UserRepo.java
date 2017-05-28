package com.ascend.todo.repositories;

import com.ascend.todo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by BiG on 5/27/2017 AD.
 */
public interface UserRepo extends JpaRepository<User, Long> {
}
