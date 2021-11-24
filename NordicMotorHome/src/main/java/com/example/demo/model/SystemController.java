package com.example.demo.model;

import com.example.demo.data.DataFacadeImpl;
import com.example.demo.model.Autocamper;
import com.example.demo.model.Customer;
import com.example.demo.model.Rental;

import java.util.ArrayList;

// nick, søren, mads og emil

public class SystemController {

    DataFacadeImpl dataFacadeimp = new DataFacadeImpl();

    //Customer

    public void addCustomer(Customer customer) {
        dataFacadeimp.addCustomer(customer);
    }

    public ArrayList<Customer> getAllCustomers() {
        return dataFacadeimp.getAllCustomers();
    }

    public Customer findCustomer(int idSearch) {
        return dataFacadeimp.findCustomer(idSearch);
    }

    public void deleteCustomer(int id) {
        dataFacadeimp.deleteCustomer(id);
    }

    //Autocamper

    public void addAutocamper(Autocamper autocamper) {
        dataFacadeimp.addAutocamper(autocamper);
    }

    public ArrayList<Autocamper> getAllAutocampers() {
        return dataFacadeimp.getAllAutocampers();
    }

    public Autocamper findAutocamper(int idSearch) {
        return dataFacadeimp.findAutocamper(idSearch);
    }

    //rental

    public void deleteAutocamper(int id) {
        dataFacadeimp.deleteAutocamper(id);
    }

    public void addRental(Rental rental) {
        dataFacadeimp.addRental(rental);
    }

    public ArrayList<Rental> getAllRentals() {
        return dataFacadeimp.getAllRentals();
    }

    public boolean checkForAutocamperAvailability(int idSearch) {
        return dataFacadeimp.checkForAutocamperAvailability(idSearch);
    }

    public boolean findAutocamperId(int idSearch) {
        return dataFacadeimp.findAutocamperId(idSearch);
    }

    public boolean checkForCustomerAvailability(int idSearch) {
        return dataFacadeimp.checkForCustomerAvailability(idSearch);
    }

    public boolean findCustomerId(int idSearch) {
        return dataFacadeimp.findCustomerId(idSearch);
    }

}
