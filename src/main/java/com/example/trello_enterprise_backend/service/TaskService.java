package com.example.trello_enterprise_backend.service;

import com.example.trello_enterprise_backend.entity.Task;
import com.example.trello_enterprise_backend.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Говорит Spring Boot: "Это класс-повар, здесь живет бизнес-логика"
public class TaskService {

    @Autowired
    private TaskRepository taskRepository; // Кладовщик

    // 1. Получить все задачи
    public List<Task> getAllTasks() 
    {
        return taskRepository.findAll();
    }
    // Получить задачи по конкретному статусу
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    // 2. Создать задачу
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    // 3. Обновить задачу
    public Task updateTask(Long id, Task taskDetails) {
        // Проверяем, есть ли такая задача (Повар проверяет продукты)
        Task task = taskRepository.findById(id).orElseThrow();
        
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        
        return taskRepository.save(task);
    }

    // 4. Удалить задачу
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}