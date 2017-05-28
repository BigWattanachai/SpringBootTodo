package com.ascend.todo.services;

import com.ascend.todo.entities.User;
import com.ascend.todo.repositories.UserRepo;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by BiG on 5/27/2017 AD.
 */
public class TodoServiceTest {
    @InjectMocks
    TodoService todoService;

    @Mock
    UserRepo userRepo;

    private User user1;
    private User user2;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        todoService = new TodoService(userRepo);

        user1 = new User();
        user1.setEmail("user1@gmail.com");
        user1.setFirstName("user1FirstName");
        user1.setLastName("user1LastName");
        user2 = new User();
        user2.setEmail("user2@gmail.com");
        user2.setFirstName("user2FirstName");
        user2.setLastName("user2LastName");
    }

    @Test
    public void shouldReturnUserWhenCreateNewUserSuccessfully() throws Exception {
        when(userRepo.saveAndFlush(Matchers.any(User.class))).thenReturn(user1);

        User userCreated = todoService.createUser(user1);
        assertThat(userCreated.getFirstName(), is("user1FirstName"));
        assertThat(userCreated.getLastName(), is("user1LastName"));
        assertThat(userCreated.getEmail(), is("user1@gmail.com"));

        verify(userRepo).saveAndFlush(Matchers.any(User.class));
    }


    @Test
    public void shouldReturnAllUserWhenGetAllExistingUserInDb() throws Exception {
        when(userRepo.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> userList = todoService.getAllUser();
        assertThat(userList.size(), is(2));
        assertThat(userList.get(0).getFirstName(), is("user1FirstName"));
        assertThat(userList.get(0).getLastName(), is("user1LastName"));
        assertThat(userList.get(0).getEmail(), is("user1@gmail.com"));
        assertThat(userList.get(1).getFirstName(), is("user2FirstName"));
        assertThat(userList.get(1).getLastName(), is("user2LastName"));
        assertThat(userList.get(1).getEmail(), is("user2@gmail.com"));

        verify(userRepo).findAll();
    }
}
