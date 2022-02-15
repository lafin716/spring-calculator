package com.example.board.service;

import com.example.board.controller.request.AddBoardRequest;
import com.example.board.controller.response.GetBoardResponse;
import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import com.example.board.util.PasswordEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository repository;

    public boolean save(AddBoardRequest request) {

        Board board = new Board();
        board.setTitle(request.getTitle());
        board.setContent(request.getContent());
        board.setWriter(request.getWriter());
        board.setPassword(PasswordEncoder.encode(request.getPassword()));
        board.setStatus(1);
        board.setCreatedAt(LocalDateTime.now());

        var newBoard = repository.save(board);

        return newBoard.getId() > 0;
    }

    public List<GetBoardResponse> list() {

        List<Board> boardList = repository.findAll();

        List<GetBoardResponse> result = boardList.stream()
                .map(GetBoardResponse::of)
                .collect(Collectors.toList());

        return result;
    }
}
