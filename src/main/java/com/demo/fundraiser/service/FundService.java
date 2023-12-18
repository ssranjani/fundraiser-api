package com.demo.fundraiser.service;

import com.demo.fundraiser.dto.FundDTO;
import com.demo.fundraiser.model.Fund;
import com.demo.fundraiser.repo.FundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundService {
    private final FundRepository fundRepo;
    @Autowired
    public FundService(FundRepository fundRepo) {
        this.fundRepo = fundRepo;
    }

    public  void saveFund(FundDTO fundDTO){
        fundRepo.save(new Fund(fundDTO));
    }

    public double calculateTotalFunds(){
        return fundRepo.findAll().stream().mapToDouble(Fund::getAmount).sum();
    }

}
