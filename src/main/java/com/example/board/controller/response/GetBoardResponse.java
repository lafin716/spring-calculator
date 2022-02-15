package com.example.board.controller.response;

import com.example.board.entity.Board;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class GetBoardResponse {

    private Long id;

    private String title;

    private String content;

    private String writer;

    private LocalDateTime createdAt;

    public static GetBoardResponse of(Board board) {
        return GetBoardResponse.builder()
                .id(board.getId())
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .createdAt(board.getCreatedAt())
                .build();
    }
}
