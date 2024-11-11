package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.UserInfoService;

@RequestMapping("/api/v1/user")
@RestController
public class UserInfoController {

    private UserInfoService userInfoService;
    
    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getTodoItem(@PathVariable("id") Long id) {
    	
        return ResponseEntity.ok(userInfoService.getUserInfo(id));
    }
}
