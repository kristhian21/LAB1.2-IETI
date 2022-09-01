package eci.edu.co.tasks.entities;

import eci.edu.co.tasks.dto.Status;
import eci.edu.co.tasks.dto.TaskDto;

import java.util.Date;

public class Task {

    private String id;
    private String name;
    private String description;
    private String status;
    private String assignedTo;
    private Date dueDate;
    private Date createdAt;

    public Task(String id, String name, String description, String status, String assignedTo, Date dueDate, Date createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public TaskDto toDto(){
        return new TaskDto(id, name, description, Status.valueOf(status), assignedTo, dueDate.toString(), createdAt.toString());
    }
}
