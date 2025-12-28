package com.example.utility_payment_processing_platform.repositories;

import com.example.utility_payment_processing_platform.entities.BillerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillerRepository extends JpaRepository<BillerEntity, String> {
}
