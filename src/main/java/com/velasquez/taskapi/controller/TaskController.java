package com.velasquez.taskapi.controller;


import com.velasquez.taskapi.entity.Task;
import com.velasquez.taskapi.model.SaveRequest;
import com.velasquez.taskapi.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

@RestController
// why rest and not just reg controller? its  rest api, gives json functionality

public class TaskController {

    // TODO: Sonarlint plugin

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @GetMapping("/tasks")
    public Iterable<Task> getTasks() {
        return taskRepository.findAll();
    }
    // TaskService - Pascal Case
    // taskId - Camel Case
    // task_id - snake case

    @PutMapping("/tasks/{taskId}")
    public void completeTask(@PathVariable String taskId) {
        Task task = taskRepository.findById(taskId).get();      // null - NPE null pointer exception
        task.setCompleted(!task.isCompleted());

        taskRepository.save(task);
    }

   @DeleteMapping("/tasks/{taskId}")
       public void deleteTask(@PathVariable String taskId){
           taskRepository.deleteById(taskId);

}

    @PostMapping("/tasks")                 // JSON JavaScript Object Notation-> Jackson-> Java object
    public void saveTask(@RequestBody SaveRequest saveRequest) {
        Task task = new Task(saveRequest.getName());             // create entity
        taskRepository.save(task);                          // save entity
    }

}
