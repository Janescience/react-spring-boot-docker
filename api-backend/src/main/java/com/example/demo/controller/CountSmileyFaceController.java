package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.response.ApiResponse;
import com.example.demo.services.CountSmileyFacesService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/countsmileys")
public class CountSmileyFaceController {

    private final CountSmileyFacesService countSmileyFaceService;

    public CountSmileyFaceController(CountSmileyFacesService countSmileyFaceService) {
        this.countSmileyFaceService = countSmileyFaceService;
    }
    
    @PostMapping
    public ResponseEntity<?> countSmileyFaces(@RequestBody String[] faces){
        return ResponseEntity.ok(new ApiResponse("Successfully.","200","success",countSmileyFaceService.count(faces)));
    }
}
