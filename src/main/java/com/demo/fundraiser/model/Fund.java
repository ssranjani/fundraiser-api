package com.demo.fundraiser.model;

import com.demo.fundraiser.dto.FundDTO;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.processing.Generated;

@Document("funds")
public class Fund {
    @Id
    private String id;
    private String donatedBy;
    private double amount;

    public Fund() {
    }

    public Fund(FundDTO fundDTO) {
        this.donatedBy = fundDTO.getDonatedBy();
        this.amount = fundDTO.getAmount();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDonatedBy() {
        return donatedBy;
    }

    public void setDonatedBy(String donatedBy) {
        this.donatedBy = donatedBy;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Fund{" +
                "id='" + id + '\'' +
                ", donatedBy='" + donatedBy + '\'' +
                ", amount=" + amount +
                '}';
    }
}
