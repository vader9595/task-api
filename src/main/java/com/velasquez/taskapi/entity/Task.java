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

    public Task(String id, String name) {
        this.id = id;
        this.name = name;
        this.completed = false;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (completed != task.completed) return false;
        if (id != null ? !id.equals(task.id) : task.id != null) return false;
        return name != null ? name.equals(task.name) : task.name == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (completed ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", completed=" + completed +
                '}';
    }
}
