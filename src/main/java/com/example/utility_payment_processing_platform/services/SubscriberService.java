package com.example.utility_payment_processing_platform.services;

import com.example.utility_payment_processing_platform.entities.Status;
import com.example.utility_payment_processing_platform.entities.SubscriberEntity;
import com.example.utility_payment_processing_platform.repositories.SubscriberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SubscriberService {
    private final SubscriberRepository subscriberrepo;

    public SubscriberService(SubscriberRepository subscriberrepo){
        this.subscriberrepo=subscriberrepo;
    }

    public SubscriberEntity register(String subscriberId, String name) {

        if (subscriberrepo.existsById(subscriberId)) {
            throw new RuntimeException(
                    "Subscriber already exists with id: " + subscriberId);
        }

        SubscriberEntity subscriber = new SubscriberEntity();
        subscriber.setId(subscriberId);
        subscriber.setName(name);
        subscriber.setStatus(Status.ACTIVE);

        subscriber.setCreatedAt(LocalDate.now());

        return subscriberrepo.save(subscriber);
    }

    public SubscriberEntity login(String subscriberId, String name) {

        // 1️⃣ Find subscriber
        SubscriberEntity subscriber = subscriberrepo.findById(subscriberId)
                .orElseThrow(() ->
                        new RuntimeException("Subscriber not found"));

        // 2️⃣ Check ACTIVE status
        if (subscriber.getStatus() != Status.ACTIVE) {
            throw new RuntimeException("Subscriber is inactive");
        }

        // 3️⃣ Update last modified time (optional but realistic)
        subscriber.setUpdatedAt(LocalDate.now());
        subscriberrepo.save(subscriber);

        return subscriber;
    }
}
