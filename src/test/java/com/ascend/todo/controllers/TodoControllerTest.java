package com.ascend.todo.controllers;


import com.ascend.todo.entities.User;
import com.ascend.todo.services.TodoService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by BiG on 5/27/2017 AD.
 */
public class TodoControllerTest {
    @InjectMocks
    private TodoController todoController;

    @Mock
    private TodoService todoService;

    private MockMvc mvc;

    private User user1;
    private User user2;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(todoController).build();
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
    public void shouldReturnAllUserWhenGetAllExistingUsersInDb() throws Exception {
        when(todoService.getAllUser()).thenReturn(Arrays.asList(user1, user2));

        mvc.perform(get("/api/v1/users"))
                .andExpect(jsonPath("$[0].first_name", is("user1FirstName")))
                .andExpect(jsonPath("$[0].last_name", is("user1LastName")))
                .andExpect(jsonPath("$[0].email", is("user1@gmail.com")))
                .andExpect(jsonPath("$[1].first_name", is("user2FirstName")))
                .andExpect(jsonPath("$[1].last_name", is("user2LastName")))
                .andExpect(jsonPath("$[1].email", is("user2@gmail.com")))
                .andExpect(status().isOk());

        verify(todoService).getAllUser();
    }
}
