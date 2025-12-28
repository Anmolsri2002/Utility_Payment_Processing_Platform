package com.example.utility_payment_processing_platform.repositories;

import com.example.utility_payment_processing_platform.entities.PaymentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    boolean existsByClientReferenceId(String clientReferenceId);
    Optional<PaymentEntity> findByTransactionId(String transactionId);
    Page<PaymentEntity> findBySubscriberId(String subscriberId, Pageable pageable);
}
