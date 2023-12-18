package com.demo.fundraiser.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/funds")
public class FundraiserController {
    @GetMapping("")
    public ResponseEntity<Integer> getFunds(){
        return  ResponseEntity.ok(56780);
    }
}
