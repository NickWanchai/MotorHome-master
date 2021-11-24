package com.example.demo.model;

// Mads og Emil (kødhovederne)
public class Autocamper {

    private int id;
    private String model;
    private String brand;
    private int capacity;
    private int manufacturingYear;
    private int rentalPrice;
    private String fuelType;
    private String towHitch;

    public Autocamper(int id, String model, String brand, int capacity, int manufacturingYear, int rentalPrice, String fuelType, String towHitch) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.capacity = capacity;
        this.manufacturingYear = manufacturingYear;
        this.rentalPrice = rentalPrice;
        this.fuelType = fuelType;
        this.towHitch = towHitch;

    }

    public Autocamper(String model, String brand, int capacity, int manufacturingYear, int rentalPrice, String fuelType, String towHitch) {
        this.model = model;
        this.brand = brand;
        this.capacity = capacity;
        this.manufacturingYear = manufacturingYear;
        this.rentalPrice = rentalPrice;
        this.fuelType = fuelType;
        this.towHitch = towHitch;

    }

    public Autocamper() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setManufacturingYear(int manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setTowHitch(String towHitch) {
        this.towHitch = towHitch;
    }


    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getManufacturingYear() {
        return manufacturingYear;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getTowHitch() {
        return towHitch;
    }


    @Override
    public String toString() {
        return "Autocamper{" +
                "id=" + id +
                ", com.example.demo.model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", capacity=" + capacity +
                ", age=" + manufacturingYear +
                ", rental price=" + rentalPrice +
                ", fuelType='" + fuelType + '\'' +
                ", towHitch='" + towHitch + '\'' +
                '}';
    }
}
