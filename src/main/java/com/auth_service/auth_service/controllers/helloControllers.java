package com.auth_service.auth_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;


@RestController

public class helloControllers {

    @GetMapping("/")
    public String getMethodName(HttpServletRequest request)  {
        return "Welcome" +  request.getSession().getId() ;
    }
    
    
}
