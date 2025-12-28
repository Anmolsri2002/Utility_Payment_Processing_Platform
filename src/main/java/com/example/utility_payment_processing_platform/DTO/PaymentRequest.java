package com.example.utility_payment_processing_platform.DTO;
import java.math.BigDecimal;
public class PaymentRequest{
    private String subscriberId;
    private String billerId;
    private BigDecimal amount;
    private String clientReferenceID;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getBillerId() {
        return billerId;
    }

    public void setBillerId(String billerId) {
        this.billerId = billerId;
    }

    public String getClientReferenceID() {
        return clientReferenceID;
    }

    public void setClientReferenceID(String clientReferenceID) {
        this.clientReferenceID = clientReferenceID;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }
}
