package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.response.ApiResponse;
import com.example.demo.services.FindOddIntService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/findoddint")
public class FindOddIntController {

    private final FindOddIntService findOddIntService;

    public FindOddIntController(FindOddIntService findOddIntService) {
        this.findOddIntService = findOddIntService;
    }
    
    @PostMapping
    public ResponseEntity<?> findOddInt(@RequestBody int[] nums){
        return ResponseEntity.ok(new ApiResponse("Successfully.","200","success",findOddIntService.find(nums)));
    }
}
