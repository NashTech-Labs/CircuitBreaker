package com.example.Resilience.j.service.B.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v2")
public class Controller {

    @GetMapping
    public String shopkeeper(){
        return "Customer order is being received by shopkeeper";
    }
}
