package com.example.utility_payment_processing_platform.controllers;

import com.example.utility_payment_processing_platform.entities.BillerEntity;
import com.example.utility_payment_processing_platform.exception.ApiResponse;
import com.example.utility_payment_processing_platform.services.BillerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billers")
public class BillerController {
    private final BillerService billerservice;

    public BillerController(BillerService billerservice){
        this.billerservice=billerservice;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(@RequestBody BillerEntity biller){
        billerservice.SaveBillerDetails(biller.getId(), biller.getCompanyName());
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<String>(biller.getId(), "Biller Registered Successfully", 201));
    }
}
