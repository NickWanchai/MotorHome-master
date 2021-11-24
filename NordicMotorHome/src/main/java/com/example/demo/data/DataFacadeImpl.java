package com.example.demo.data;

import com.example.demo.model.Autocamper;
import com.example.demo.model.Customer;
import com.example.demo.model.DataFacade;
import com.example.demo.model.Rental;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

//Søren
@Service
public class DataFacadeImpl implements DataFacade {

    private CustomerMapper customerMapper = new CustomerMapper();
    private AutocamperMapper autocamperMapper = new AutocamperMapper();
    private RentalMapper rentalMapper = new RentalMapper();

    //Customer
    @Override
    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
    }

    @Override
    public ArrayList<Customer> getAllCustomers() {
        return customerMapper.getAllCustomers();
    }

    @Override
    public Customer findCustomer(int idSearch) {
        return customerMapper.findCustomer(idSearch);
    }

    @Override
    public void deleteCustomer(int id) {
        customerMapper.deleteCustomer(id);
    }

    //Autocamper
    @Override
    public void addAutocamper(Autocamper autocamper) {
        autocamperMapper.addAutocamper(autocamper);
    }

    @Override
    public ArrayList<Autocamper> getAllAutocampers() {
        return autocamperMapper.getAllAutocampers();
    }

    @Override
    public Autocamper findAutocamper(int idSearch) {
        return autocamperMapper.findAutocamper(idSearch);
    }

    @Override
    public void deleteAutocamper(int id) {
        autocamperMapper.deleteAutocamper(id);
    }

    @Override
    public void addRental(Rental rental) {
        rentalMapper.addRental(rental);
    }

    @Override
    public ArrayList<Rental> getAllRentals() {
        return rentalMapper.getAllRentals();
    }

    @Override
    public boolean checkForAutocamperAvailability(int idSearch) {
        return rentalMapper.checkForAutocamperAvailability(idSearch);
    }

    @Override
    public boolean findAutocamperId(int idSearch) {
        return rentalMapper.findAutocamperId(idSearch);
    }

    @Override
    public boolean checkForCustomerAvailability(int idSearch) {
        return rentalMapper.checkForCustomerAvailability(idSearch);
    }

    @Override
    public boolean findCustomerId(int idSearch) {
        return rentalMapper.findCustomerId(idSearch);
    }


}
