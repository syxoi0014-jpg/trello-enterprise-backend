package com.example.trello_enterprise_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "boards")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // ==========================================
    // ОБРАТНАЯ СВЯЗЬ: Одна доска содержит Много задач
    // ==========================================
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    @JsonIgnore // Защита от бесконечного цикла (Доска вызывает Задачу -> Задача вызывает Доску -> Сервер падает)
    private List<Task> tasks;

    // ==========================================
    // ГЕТТЕРЫ И СЕТТЕРЫ
    // ==========================================

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Task> getTasks() { return tasks; }
    public void setTasks(List<Task> tasks) { this.tasks = tasks; }
}