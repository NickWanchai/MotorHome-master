package com.example.demo.data;

import com.example.demo.model.Customer;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

//Nick og Søren
public class CustomerMapper {

    //tilføjer kunde til database
    public void addCustomer(Customer customer) {
        try {

            LocalDate date = customer.getBirthday();
            Date SQLdate = Date.valueOf(date);
            Connection connection = DBConnectionManager.getConnection();
            String SQL = "INSERT INTO customer VALUES(DEFAULT,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setDate(3, SQLdate);
            ps.setString(4, customer.getEmail());
            ps.setInt(5, customer.getZipCode());
            ps.setString(6, customer.getAdress());
            ps.setInt(7, customer.getPhonenumber());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Returnerer en arrayliste med alle kunde fra databasen
    public ArrayList<Customer> getAllCustomers() {

        ArrayList<Customer> customers = new ArrayList<>();
        try {
            Connection connection = DBConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from customer";
            ResultSet rs = statement.executeQuery(sql);
            int id;
            String firstName;
            String lastName;
            Date _Date;
            LocalDate birthday;
            String email;
            int zipCode;
            String adress;
            int phonenumber;
            Customer customer;

            while (rs.next()) {
                id = rs.getInt("customer_id");
                firstName = rs.getString("first_name");
                lastName = rs.getString("last_name");
                _Date = rs.getDate("birthday");
                birthday = _Date.toLocalDate();
                email = rs.getString("email");
                zipCode = rs.getInt("zip_code");
                adress = rs.getString("adress");
                phonenumber = rs.getInt("phonenumber");
                customer = new Customer(id, firstName, lastName, birthday, email, zipCode, adress, phonenumber);
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    //Returnerer kunden der har id'et fra metodens parameter
    public Customer findCustomer(int idSearch) {

        Customer customer = null;
        try {
            Connection connection = DBConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM customer";
            ResultSet rs = statement.executeQuery(sql);
            int id;
            String firstName;
            String lastName;
            Date _Date;
            LocalDate age;
            String email;
            int zipCode;
            String adress;
            int phonenumber;

            while (rs.next()) {
                id = rs.getInt("customer_id");
                firstName = rs.getString("first_name");
                lastName = rs.getString("last_name");
                _Date = rs.getDate("birthday");
                age = _Date.toLocalDate();
                email = rs.getString("email");
                zipCode = rs.getInt("zip_code");
                adress = rs.getString("adress");
                phonenumber = rs.getInt("phonenumber");

                if (id == idSearch) {
                    return new Customer(id, firstName, lastName, age, email, zipCode, adress, phonenumber);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    //Sletter kunde fra Database
    public void deleteCustomer(int id) {
        try {
            Connection connection = DBConnectionManager.getConnection();
            String sql = "DELETE FROM customer WHERE customer_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
