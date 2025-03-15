package org.example.springsecuritydemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
public class HelloController {


    @GetMapping("/")
    public String getUsers(HttpServletRequest request) {
        return "Satyajit " + request.getSession().getId();
    }
}
