package com.example.trello_enterprise_backend.controller;

import com.example.trello_enterprise_backend.entity.Task;
import com.example.trello_enterprise_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    @Autowired
    private TaskService taskService; // Теперь Официант общается только с Поваром!

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks(); // Передали заказ на кухню
    }
    // Поиск по статусу. Путь будет выглядеть так: /api/tasks/status/TODO
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return taskService.getTasksByStatus(status);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

   @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        return taskService.updateTask(id, taskDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}