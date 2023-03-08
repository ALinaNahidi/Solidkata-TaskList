package com.codurance.training.tasks;

import java.util.Date;

public final class Task {
    private String id;
    private final String description;
    private boolean done;
    private Date deadline;
    private final Date createdAt;

    public Task(String id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
        this.createdAt = new Date();
    }

    public Task(String id, String description, boolean done, Date deadline) {
        this.id = id;
        this.description = description;
        this.done = done;
        this.createdAt = new Date();
        this.deadline = deadline;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
