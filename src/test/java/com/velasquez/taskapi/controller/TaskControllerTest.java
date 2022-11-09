package com.velasquez.taskapi.controller;

import com.velasquez.taskapi.entity.Task;
import com.velasquez.taskapi.repository.TaskRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
        when(mockRepository.findAll())
                .thenReturn(List.of(new Task("Check the mail")));

        mockMvc.perform(get("/tasks"))
                .andDo(print())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("Check the mail")))
                .andExpect(jsonPath("$[0].completed", is(false)));
    }

    @Test
    void completesTask() throws Exception {
        Task task = new Task("123", "Check the mail");
        when(mockRepository.findById("123"))
                .thenReturn(Optional.of(task));

        mockMvc.perform(put("/tasks/123"))
                .andDo(print());

        ArgumentCaptor<Task> argumentCaptor = ArgumentCaptor.forClass(Task.class);
        verify(mockRepository).save(argumentCaptor.capture());

        Task updatedTask = argumentCaptor.getValue();

        assertThat(updatedTask.getId()).isEqualTo("123");
        assertThat(updatedTask.getName()).isEqualTo("Check the mail");
        assertThat(updatedTask.isCompleted()).isTrue();
    }
}