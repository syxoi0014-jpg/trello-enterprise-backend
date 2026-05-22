package com.example.trello_enterprise_backend.repository;

import com.example.trello_enterprise_backend.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List; // Не забудь, что List нужно импортировать!

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    
    // Магия Spring: мы просто пишем имя метода, а он сам делает SQL!
    List<Task> findByStatus(String status);
}