package com.codility.tasks.hibernate.solution.demotaskapplication.demotaskapplication1;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TaskRequest {

    @NotBlank(message = "Task description is required")
    @Size(max = 200)
    private String description;

    private Long priority;

    public TaskRequest() {
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
