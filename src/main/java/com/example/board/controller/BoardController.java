package com.example.board.controller;

import com.example.board.controller.request.AddBoardRequest;
import com.example.board.controller.response.GetBoardResponse;
import com.example.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;

    @GetMapping("")
    public String hello() {
        return "Hi";
    }

    @PostMapping("/add")
    public String add(@RequestBody AddBoardRequest request) {

        boolean result = service.save(request);

        if (!result) {
            return "실패";
        }

        return "성공";
    }

    @GetMapping("/list")
    public ResponseEntity<Object> list() {

        List<GetBoardResponse> result = service.list();

        return ResponseEntity.ok(result);
    }

}
