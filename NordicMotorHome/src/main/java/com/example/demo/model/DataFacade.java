package com.example.demo.model;

import java.util.ArrayList;

//Søren

public interface DataFacade {

    public void addCustomer(Customer customer);

    public ArrayList<Customer> getAllCustomers();

    public Customer findCustomer(int idSearch);

    public void deleteCustomer(int id);

    public void addAutocamper(Autocamper autocamper);

    public ArrayList<Autocamper> getAllAutocampers();

    public Autocamper findAutocamper(int idSearch);

    public void deleteAutocamper(int id);

    public ArrayList<Rental> getAllRentals();

    public void addRental(Rental rental);

    public boolean checkForAutocamperAvailability(int idSearch);

    public boolean findAutocamperId(int idSearch);

    public boolean checkForCustomerAvailability(int idSearch);

    public boolean findCustomerId(int idSearch);

}
