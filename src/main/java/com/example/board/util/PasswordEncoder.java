package com.example.board.util;

import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

public class PasswordEncoder {

    public static String encode(String plainText) {
        return Base64Utils.encode(plainText.getBytes()).toString();
    }
}
