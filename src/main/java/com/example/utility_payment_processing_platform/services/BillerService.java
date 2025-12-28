package com.example.utility_payment_processing_platform.services;

import com.example.utility_payment_processing_platform.entities.BillerEntity;
import com.example.utility_payment_processing_platform.repositories.BillerRepository;
import org.springframework.stereotype.Service;

@Service
public class BillerService {
    private final BillerRepository billrepo;
    public BillerService(BillerRepository billrepo){
        this.billrepo=billrepo;
    }
    public BillerEntity SaveBillerDetails(String billerId, String CompanyName){
        if(billrepo.existsById(billerId)){
            throw new RuntimeException("Biller already exists with id : "+billerId);
        }
        BillerEntity biller=new BillerEntity();
        biller.setId(billerId);
        biller.setCompanyName(CompanyName);

        return billrepo.save(biller);
    }
}
