package com.codility.tasks.hibernate.solution.demotaskapplication.demotaskapplication1;

public class TaskMapper {

    public static Task fromTaskRequest(TaskRequest taskRequest) {
        Task task = new Task();
        task.setDescription(taskRequest.getDescription());
        task.setPriority(taskRequest.getPriority());
        return task;
    }
}
