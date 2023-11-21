package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.response.ApiResponse;
import com.example.demo.services.PermutationService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/permutation")
public class PermutationController {

    private final PermutationService permetationSevice;

    public PermutationController(PermutationService permetationSevice) {
        this.permetationSevice = permetationSevice;
    }
    
    @GetMapping("/{str}")
    public ResponseEntity<?> permutation(@PathVariable String str){
        return ResponseEntity.ok(new ApiResponse("Successfully.","200","success",permetationSevice.shufflings(str)));
    }


    
}
