package com.luv2code.springdemo.rest;

import com.luv2code.springdemo.entity.Task;
import com.luv2code.springdemo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolist")
public class TaskRESTController {
    private TaskService taskService;

    @Autowired
    public TaskRESTController(TaskService taskService) {
        this.taskService = taskService;
    }

    //Expose methode
    @CrossOrigin("http://localhost:9090")
    @GetMapping("")
    public List<Task> getAllTask() {
        return taskService.getTaskList();
    }

    //Find task by ID
    @GetMapping("/{task_id}")
    public Task getTaskById(@PathVariable int task_id) {
        return taskService.getTaskById(task_id);
    }

    //Put request, parsing json body
    @PutMapping("")
    public Task updateTask(@RequestBody Task task) {
        taskService.saveTask(task);
        return task;
    }

    //Delete Mapping
    @DeleteMapping("/{task_id}")
    public String  deleteTaskById(@PathVariable int task_id){
        taskService.deleteTask(task_id);
        return "task id : " + task_id + " delete successful";
    }
}
