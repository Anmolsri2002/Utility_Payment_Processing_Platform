package com.example.utility_payment_processing_platform.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="Payments")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="TransactionID", nullable = false, unique=true)
    private String transactionId;

    @Column(name="BillerID", nullable = false)
    private String billerID;

    @Column(name="SubscriberID", nullable = false)
    private String subscriberId;

    @Column(name="Amount", nullable = false)
    private BigDecimal amount;

    @Column(name="ClientReferenceID", unique = true)
    private String clientReferenceId;

    @Enumerated(EnumType.STRING)
    @Column(name="Status", nullable = false)
    private PaymentStatus status;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBillerID() {
        return billerID;
    }

    public void setBillerID(String billerID) {
        this.billerID = billerID;
    }

    public String getClientReferenceId() {
        return clientReferenceId;
    }

    public void setClientReferenceId(String clientReferenceId) {
        this.clientReferenceId = clientReferenceId;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
