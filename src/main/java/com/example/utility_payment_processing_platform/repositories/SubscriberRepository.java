package com.example.utility_payment_processing_platform.repositories;

import com.example.utility_payment_processing_platform.entities.SubscriberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends JpaRepository<SubscriberEntity, String> {

}
