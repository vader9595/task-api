package com.velasquez.taskapi.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    private String id;
    private String name;
    private boolean completed;                                         //lowercase boolean starts as false


    public Task() {
    }


    public Task(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.completed = false;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {            //alt insert for getters and settters
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }



}
