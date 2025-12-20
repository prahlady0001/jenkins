package com.spring_jenkins.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jen")
public class JenController {

    @GetMapping
    public String print() {
        return "Wellcome To India Good morning ";
    }
}
