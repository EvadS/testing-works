package com.codility.tasks.hibernate.solution.demotaskapplication.demotaskapplication1;

public class TaskResponseMapper {
    public static TaskResponse fromTask(Task task) {
        TaskResponse taskResponse = new TaskResponse(task.getDescription(), task.getPriority());
        return taskResponse;
    }
}