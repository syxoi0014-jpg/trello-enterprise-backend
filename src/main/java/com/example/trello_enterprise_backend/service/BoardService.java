package com.example.trello_enterprise_backend.service;

import com.example.trello_enterprise_backend.entity.Board;
import com.example.trello_enterprise_backend.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository; // Наш кладовщик для досок

    // Получить все доски
    public List<Board> getAllBoards() {
        return boardRepository.findAll();
    }

    // Создать новую доску
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }
// Удалить доску
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }}