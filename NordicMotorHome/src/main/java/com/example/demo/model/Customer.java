package com.example.demo.model;

import java.time.LocalDate;

// Nick og Søren

public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private LocalDate birthday;
    private String email;
    private int zipCode;
    private String adress;
    private int phonenumber;


    public Customer() {
    }

    public Customer(int id, String firstName, String lastName, LocalDate birthday, String email, int zipCode, String adress, int phonenumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.zipCode = zipCode;
        this.adress = adress;
        this.phonenumber = phonenumber;
    }

    public Customer(String firstName, String lastName, LocalDate birthday, String email, int zipCode, String adress, int phonenumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.email = email;
        this.zipCode = zipCode;
        this.adress = adress;
        this.phonenumber = phonenumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", zipCode=" + zipCode +
                ", adress='" + adress + '\'' +
                ", phonenumber=" + phonenumber +
                '}';
    }
}
