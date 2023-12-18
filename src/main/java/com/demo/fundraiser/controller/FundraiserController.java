package com.demo.fundraiser.controller;

import com.demo.fundraiser.dto.FundDTO;
import com.demo.fundraiser.service.FundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/funds")
public class FundraiserController {
    private final FundService fundService;
    @Autowired
    public FundraiserController(FundService fundService) {
        this.fundService = fundService;
    }

    @GetMapping("")
    public ResponseEntity<Integer> getFunds(){
        double total = fundService.calculateTotalFunds();
        return  ResponseEntity.ok((int)total);
    }

    @PostMapping("")
    public void saveFunds(@RequestBody FundDTO fundDTO){
        fundService.saveFund(fundDTO);

    }
}
