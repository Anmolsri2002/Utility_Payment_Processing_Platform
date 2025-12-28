package com.example.utility_payment_processing_platform.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Subscriber")
public class SubscriberEntity {

    @Id
    @Column(name="ID", length=15)
    private String id;

    @Column(name="Name", length=25, nullable=false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name="Status", length=20, nullable=false)
    private Status status;

    @Column(name="created_at", updatable=false)
    private LocalDate createdAt;

    @Column(name="updated_at")
    private LocalDate updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
