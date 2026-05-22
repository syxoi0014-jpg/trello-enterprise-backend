package com.example.trello_enterprise_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status;

    // ==========================================
    // НОВАЯ СВЯЗЬ: Много задач принадлежат Одной доске
    // ==========================================
    @ManyToOne
    @JoinColumn(name = "board_id") // В таблице tasks появится колонка board_id
    private Board board;

    // ==========================================
    // ГЕТТЕРЫ И СЕТТЕРЫ
    // ==========================================

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Board getBoard() { return board; }
    public void setBoard(Board board) { this.board = board; }
}