package com.example.Resilience.j.service.A.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/v1")
public class MainController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8081/";

    private static final String CUSTOMER = "customer";
    @GetMapping
    @CircuitBreaker(name =CUSTOMER , fallbackMethod = "customerFallbackMethod")
    public String customer(){
        String url = BASE_URL + "v2";
        return   restTemplate.getForObject(url,String.class);

    }

    public String customerFallbackMethod(Exception e){
        return "The shopkeeper is not avaliable for taking order";
    }
}
