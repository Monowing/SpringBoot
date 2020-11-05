package com.example.demo.token.controller;


import com.example.demo.token.Annotation.TokenCheck;
import org.springframework.http.HttpRequest;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/token")
public class TokenController {

    @TokenCheck(check = true)
    @GetMapping("/data/check")
    public String getCheckData() {
        return "get check data";
    }

    @TokenCheck(check = false)
    @GetMapping("/data/notcheck")
    public String getNotCheckData() {
        return "get not check data";
    }



}
