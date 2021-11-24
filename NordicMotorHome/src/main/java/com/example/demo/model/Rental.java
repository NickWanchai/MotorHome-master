package com.example.demo.model;

import java.time.LocalDate;

// Nick, Søren, mads og emil

public class Rental {

    private int rentalId;
    private int customerId;
    private int autocamperId;
    private LocalDate dateOfRent;

    public Rental(int rentalId, int customerId, int autocamperId, LocalDate dateOfRent) {
        this.rentalId = rentalId;
        this.customerId = customerId;
        this.autocamperId = autocamperId;
        this.dateOfRent = dateOfRent;
    }

    public Rental(int customerId, int autocamperId, LocalDate dateOfRent) {
        this.customerId = customerId;
        this.autocamperId = autocamperId;
        this.dateOfRent = dateOfRent;
    }

    public Rental() {
    }

    public int getRentalId() {
        return rentalId;
    }

    public void setRentalId(int rentalId) {
        this.rentalId = rentalId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAutocamperId() {
        return autocamperId;
    }

    public void setAutocamperId(int autocamperId) {
        this.autocamperId = autocamperId;
    }

    public LocalDate getDateOfRent() {
        return dateOfRent;
    }

    public void setDateOfRent(LocalDate dateOfRent) {
        this.dateOfRent = dateOfRent;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "rentalId=" + rentalId +
                ", customerId=" + customerId +
                ", autocamperId=" + autocamperId +
                '}';
    }
}
