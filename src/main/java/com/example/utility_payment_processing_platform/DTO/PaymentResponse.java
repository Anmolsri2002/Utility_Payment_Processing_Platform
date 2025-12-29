package com.example.utility_payment_processing_platform.DTO;

import java.math.BigDecimal;

public class PaymentResponse {
    private String transactionId;
    private String subscriberId;
    private String subscriberName;
    private String billerId;
    private String companyName;
    private BigDecimal amount;
    private String status;



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

    public PaymentResponse(BigDecimal amount, String billerId, String companyName, String status, String subscriberId, String subscriberName, String transactionId) {
        this.amount = amount;
        this.billerId = billerId;
        this.companyName = companyName;
        this.status = status;
        this.subscriberId = subscriberId;
        this.subscriberName = subscriberName;
        this.transactionId = transactionId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getBillerId() {
        return billerId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getStatus() {
        return status;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public String getSubscriberName() {
        return subscriberName;
    }
}
