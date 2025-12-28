package com.example.utility_payment_processing_platform.DTO;

public class PaymentResponse {
    private String transactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public PaymentResponse() {
    }

    public PaymentResponse(String transactionId) {
        this.transactionId = transactionId;
    }
}
