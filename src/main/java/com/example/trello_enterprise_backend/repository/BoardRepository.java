package com.example.trello_enterprise_backend.repository;

import com.example.trello_enterprise_backend.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    // Spring Boot сам напишет за нас все SQL-запросы для сохранения и поиска досок!
}