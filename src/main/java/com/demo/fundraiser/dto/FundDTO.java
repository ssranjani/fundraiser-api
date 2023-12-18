package com.demo.fundraiser.dto;

public class FundDTO {
    private String id;
    private String donatedBy;
    private double amount;

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
        return "FundDTO{" +
                "id='" + id + '\'' +
                ", donatedBy='" + donatedBy + '\'' +
                ", amount=" + amount +
                '}';
    }


}
