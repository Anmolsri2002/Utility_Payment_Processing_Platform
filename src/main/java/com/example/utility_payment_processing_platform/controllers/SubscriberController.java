package com.example.utility_payment_processing_platform.controllers;

import com.example.utility_payment_processing_platform.entities.SubscriberEntity;
import com.example.utility_payment_processing_platform.exception.ApiResponse;
import com.example.utility_payment_processing_platform.services.SubscriberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subscribers")
public class SubscriberController {
    private final SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService){
        this.subscriberService=subscriberService;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<String>> register(@RequestBody SubscriberEntity subscriber){
        subscriberService.register(subscriber.getId(), subscriber.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(subscriber.getId(), "Subscriber Registered Successfully", 201));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<SubscriberEntity>> login(@RequestBody SubscriberEntity subscriber){
        subscriber=subscriberService.login(subscriber.getId(), subscriber.getName());
        return ResponseEntity.ok(new ApiResponse<>(subscriber, "Login Successful", 200));
    }
}
