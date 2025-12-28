package com.example.utility_payment_processing_platform.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Biller")
public class BillerEntity{
    @Id
    @Column(name="BillerID", length=15)
    private String id;

    @Column(name="Company", length=25, nullable=false)
    private String CompanyName;

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        this.CompanyName = companyName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
