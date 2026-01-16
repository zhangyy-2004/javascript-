package com.example.demo.controller;

import com.example.demo.service.AiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
@CrossOrigin
public class AiController {
    @Autowired
    private AiService service;

    @RequestMapping("/chat")
    public String chat(String question) {
        return service.chat(question);
    }
}
