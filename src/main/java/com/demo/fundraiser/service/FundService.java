package com.demo.fundraiser.service;

import com.demo.fundraiser.dto.FundDTO;
import com.demo.fundraiser.model.Fund;
import com.demo.fundraiser.repo.FundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class FundService {
    private final FundRepository fundRepo;
    private final AzureEventService azureEventService;
    @Autowired
    public FundService(FundRepository fundRepo, AzureEventService azureEventService) {
        this.fundRepo = fundRepo;
        this.azureEventService = azureEventService;
    }

    public  void saveFund(FundDTO fundDTO){
        fundRepo.save(new Fund(fundDTO));
        azureEventService.publishEvent(fundDTO.getAmount());
    }

    public double calculateTotalFunds(){
        return fundRepo.findAll().stream().mapToDouble(Fund::getAmount).sum();
    }

}
