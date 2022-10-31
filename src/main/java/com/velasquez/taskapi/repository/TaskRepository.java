package com.velasquez.taskapi.repository;

import com.velasquez.taskapi.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository <Task,String> {

}
