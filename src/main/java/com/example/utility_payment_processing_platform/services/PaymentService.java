package com.example.utility_payment_processing_platform.services;

import com.example.utility_payment_processing_platform.DTO.*;
import com.example.utility_payment_processing_platform.entities.*;
import com.example.utility_payment_processing_platform.repositories.*;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {
    private final PaymentRepository paymentrepo;
    private final SubscriberRepository subscriberrepo;
    private final BillerRepository billerrepo;

    public PaymentService(PaymentRepository paymentrepo, SubscriberRepository subscriberrepo, BillerRepository billerrepo){
        this.paymentrepo=paymentrepo;
        this.subscriberrepo=subscriberrepo;
        this.billerrepo=billerrepo;
    }

    @Transactional
    public PaymentResponse initiatePayment(PaymentRequest Payreq){
        SubscriberEntity subscriber=subscriberrepo.findById(Payreq.getSubscriberId()).orElseThrow(()->
                new RuntimeException("Subscriber not found"));
        if(subscriber.getStatus()!=Status.ACTIVE){
            throw new RuntimeException("Subscriber is Inactive");
        }
        BillerEntity biller = billerrepo.findById(Payreq.getBillerId()).orElseThrow(()->
                new RuntimeException("Biller not found"));
        PaymentEntity payment=new PaymentEntity();
        payment.setTransactionId(UUID.randomUUID().toString());
        payment.setSubscriberId(Payreq.getSubscriberId());
        payment.setBillerID(Payreq.getBillerId());
        payment.setAmount(Payreq.getAmount());
        payment.setClientReferenceId(Payreq.getClientReferenceID());
        payment.setStatus(PaymentStatus.INITIATED);

        paymentrepo.save(payment);

        return new PaymentResponse(payment.getTransactionId());
    }

    public PaymentResponse getByTransactionId(String transactionId) {
        PaymentEntity payment = paymentrepo.findByTransactionId(transactionId)
                .orElseThrow(() ->
                        new RuntimeException("Payment not found"));

        return new PaymentResponse(payment.getTransactionId());
    }

    private PaymentResponse toDto(PaymentEntity PayEntity){
        PaymentResponse payres = new PaymentResponse();
        payres.setTransactionId(PayEntity.getTransactionId());
        return payres;
    }
    public Page<PaymentResponse> getPayments(
            String subscriberId, int page, int size, String sortBy, String direction){
        Sort sort=direction.equalsIgnoreCase("desc")?Sort.by(sortBy).descending():Sort.by(sortBy).ascending();
        Pageable pageable= PageRequest.of(page, size, sort);
        return paymentrepo.findBySubscriberId(subscriberId, pageable).map(this::toDto);
    }
}
