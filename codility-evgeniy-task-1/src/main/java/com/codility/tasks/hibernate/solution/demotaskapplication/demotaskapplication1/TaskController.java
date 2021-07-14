package com.codility.tasks.hibernate.solution.demotaskapplication.demotaskapplication1;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping
public class TaskController {

    private static final Logger log = Logger.getLogger("Solution");
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    // log.info("You can use 'log' for debug messages");

    @PostMapping("/tasks")
    public ResponseEntity<TaskResponse> addAnswer(@RequestBody @Valid TaskRequest taskRequest) {
        Task task = TaskMapper.fromTaskRequest(taskRequest);
        task = taskRepository.save(task);

        return ResponseEntity.ok(TaskResponseMapper.fromTask(task));
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity updateUser(@PathVariable String id,
                                     @RequestBody TaskRequest taskRequest) {

        if (id == null) {
            throw new ResourceNotFoundException("Cannot find task with given id");
        }

        Long taskID = Long.valueOf(id);

        if (taskID == null || taskID < 0) {
            throw new ResourceNotFoundException("Cannot find task with given id");
        }

        if(taskRequest.getDescription() == null || taskRequest.getDescription().length() == 0){
            ErrorResponse errorResponse = new ErrorResponse("Task description is required",
                    HttpStatus.BAD_REQUEST.value());

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }


        Optional<Task> taskOpt = taskRepository.findById(taskID);

        if (!taskOpt.isPresent()) {
            ErrorResponse errorResponse = new ErrorResponse("Cannot find task with given id",
                    HttpStatus.NOT_FOUND.value());

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }

        Task task = taskOpt.get();

        task.setDescription(taskRequest.getDescription());
        task.setPriority(taskRequest.getPriority());
        taskRepository.save(task);


        return ResponseEntity.ok(TaskResponseMapper.fromTask(task));
    }
}