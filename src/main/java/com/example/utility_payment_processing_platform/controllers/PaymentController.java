package com.example.utility_payment_processing_platform.controllers;

import com.example.utility_payment_processing_platform.DTO.PaymentRequest;
import com.example.utility_payment_processing_platform.DTO.PaymentResponse;
import com.example.utility_payment_processing_platform.exception.ApiResponse;
import com.example.utility_payment_processing_platform.services.PaymentService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    // Initiate Payment
    @PostMapping
    public ResponseEntity<ApiResponse<PaymentResponse>> initiatePayment(
            @RequestBody PaymentRequest request) {

        PaymentResponse response = paymentService.initiatePayment(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(response, "Payment initiated", 201));
    }

    // Fetch by transactionId
    @GetMapping("/{transactionId}")
    public ResponseEntity<ApiResponse<PaymentResponse>> getByTransactionId(
            @PathVariable String transactionId) {

        return ResponseEntity.ok(
                new ApiResponse<>(paymentService.getByTransactionId(transactionId), "Payment fetched",
                        200)
        );
    }

    // Fetch all payments for subscriber
    @GetMapping("/subscriber/{subscriberId}")
    public ResponseEntity<ApiResponse<Page<PaymentResponse>>> getPaymentsBySubscriber(
            @PathVariable String subscriberId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        return ResponseEntity.ok(
                new ApiResponse<>(paymentService.getPayments(subscriberId, page, size, sortBy, direction), "Payments fetched",
                        200)
        );
    }
}
