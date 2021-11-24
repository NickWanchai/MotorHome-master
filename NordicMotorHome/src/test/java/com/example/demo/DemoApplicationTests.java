package com.example.demo;

import com.example.demo.data.AutocamperMapper;
import com.example.demo.data.CustomerMapper;
import com.example.demo.model.Autocamper;
import com.example.demo.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


//Emil

@SpringBootTest
class DataTest {
    @Test
    void testFindAll_MoreThanOneFound() {
        // Arrange
        AutocamperMapper mapper = new AutocamperMapper();
        ArrayList<Autocamper> allAutocampers = mapper.getAllAutocampers();
        assertTrue(allAutocampers.size() > 0, "No autocampers found");
    }
    /*
    @Test
    void deleteAutocamper_AutocamperDeleted(){
        AutocamperMapper mapper = new AutocamperMapper();
        ArrayList<Autocamper> allAutocampers = mapper.getAllAutocampers();
        int autocamperToBeDelted = allAutocampers.get(1).getId();
        mapper.deleteAutocamper(autocamperToBeDelted);
        Autocamper autocamper = mapper.findAutocamper(autocamperToBeDelted);
        assertNull( autocamper, "still in db");
    }

     */

    @Test
    void addAutocamper_AutocamperAddet() {
        AutocamperMapper mapper = new AutocamperMapper();
        ArrayList<Autocamper> allAutocampers = mapper.getAllAutocampers();
        Autocamper testCamper = new Autocamper(700, "Fjocus", "ford", 6, 1990, 6, "Benzin", "Hitch");
        mapper.addAutocamper(testCamper);
        assertThat(allAutocampers.contains(testCamper));
    }

    @Test
    void findAllCustomers_ExpectedMoreThanOneFound() {
        CustomerMapper customermapper = new CustomerMapper();
        ArrayList<Customer> allCustomers = customermapper.getAllCustomers();
        assertTrue(allCustomers.size() > 0, "More than one customer found");
    }

    /*
    @Test
    void deleteCustomer_ExcpectedCustomerDeleted(){
        CustomerMapper mapper = new CustomerMapper();
        ArrayList<Customer> allCustomers = mapper.getAllCustomers();
        int customerToBeDelted = allCustomers.get(1).getId();
        mapper.deleteCustomer(customerToBeDelted);
        Customer customer = mapper.findCustomer(customerToBeDelted);
        assertNull( customer, "still in db");
    }

     */

    @Test
    void addCustomer_ExcpectedCustomerAddet() {
        CustomerMapper mapper = new CustomerMapper();
        ArrayList<Customer> allCustomers = mapper.getAllCustomers();
        Customer testCustomer = new Customer(700, "Nick", "Larsen", LocalDate.of(1993, 11, 15), "Nick@Nick.dk", 2860, "hvej 2", 44755888);
        mapper.addCustomer(testCustomer);
        assertThat(allCustomers.contains(testCustomer));
    }
}