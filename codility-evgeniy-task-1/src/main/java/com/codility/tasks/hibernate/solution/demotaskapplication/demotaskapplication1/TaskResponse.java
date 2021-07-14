package com.codility.tasks.hibernate.solution.demotaskapplication.demotaskapplication1;

public class TaskResponse {
    private String description;
    private Long priority;

    public TaskResponse() {
    }

    public TaskResponse(String description, Long priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }
}
