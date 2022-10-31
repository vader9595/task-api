package com.velasquez.taskapi.controller;

import com.velasquez.taskapi.entity.Task;
import com.velasquez.taskapi.repository.TaskRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {


    // Integration Test - tests multiple components interacting with each other

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TaskRepository mockRepository;

    @Test
    void returnsAllTasks() throws Exception {
        Mockito.when(mockRepository.findAll())
                .thenReturn(List.of(new Task("Check the mail")));

        mockMvc.perform(get("/tasks"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Check the mail")))
                .andExpect(jsonPath("$[0].completed", is(false)));
    }
}