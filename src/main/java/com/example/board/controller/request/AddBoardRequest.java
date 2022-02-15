package com.example.board.controller.request;

import lombok.Data;

@Data
public class AddBoardRequest {

    private String title;

    private String content;

    private String writer;

    private String password;
}
