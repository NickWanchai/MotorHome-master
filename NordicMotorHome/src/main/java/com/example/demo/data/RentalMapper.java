package com.example.demo.data;

import com.example.demo.model.Autocamper;
import com.example.demo.model.Customer;
import com.example.demo.model.Rental;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

//Nick Søren og Mads
public class RentalMapper {

    //Tilføjer udlejning til databasen
    public void addRental(Rental rental) {
        try {
            LocalDate date = rental.getDateOfRent();
            Date SQLdate = Date.valueOf(date);
            Connection connection = DBConnectionManager.getConnection();
            String SQL = "INSERT INTO autocamper_rental VALUES(DEFAULT,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, rental.getCustomerId());
            ps.setInt(2, rental.getAutocamperId());
            ps.setDate(3, SQLdate);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Returnerer en arrayliste med alle udlejninger fra databasen
    public ArrayList<Rental> getAllRentals() {

        ArrayList<Rental> rentals = new ArrayList<>();
        try {
            Connection connection = DBConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from autocamper_rental";
            ResultSet rs = statement.executeQuery(sql);
            int rentalId;
            int customerId;
            int autocamperId;
            Date _Date;
            LocalDate dateOfRent;
            Rental rental;

            while (rs.next()) {
                rentalId = rs.getInt("autocamper_rental_id");
                customerId = rs.getInt("customer_id");
                autocamperId = rs.getInt("autocamper_id");
                _Date = rs.getDate("date_of_rent");
                dateOfRent = _Date.toLocalDate();
                rental = new Rental(rentalId, customerId, autocamperId, dateOfRent);
                rentals.add(rental);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rentals;
    }


    //Metode ser om autocamper allerede er udlejet...
    public boolean checkForAutocamperAvailability(int idSearch) {

        ArrayList<Rental> rentals = getAllRentals();

        for (Rental rental : rentals) {
            if (rental.getAutocamperId() == idSearch) {
                return true;
            }
        }
        return false;
    }

    //metode ser om autocamper ID findes når en udlejning oprettes
    public boolean findAutocamperId(int idSearch) {
        AutocamperMapper aM = new AutocamperMapper();

        ArrayList<Autocamper> autocampers = aM.getAllAutocampers();

        for (Autocamper autocamper : autocampers) {
            if (autocamper.getId() == idSearch) {
                return true;
            }
        }
        return false;
    }

    //Ser om kunde allerede udlejer en autocamper
    public boolean checkForCustomerAvailability(int idSearch) {

        ArrayList<Rental> rentals = getAllRentals();

        for (Rental rental : rentals) {
            if (rental.getCustomerId() == idSearch) {
                return true;
            }
        }
        return false;
    }

    //metode ser om kunde ID findes når en udlejning oprettes
    public boolean findCustomerId(int idSearch) {
        CustomerMapper cM = new CustomerMapper();

        ArrayList<Customer> customers = cM.getAllCustomers();

        for (Customer customer : customers) {
            if (customer.getId() == idSearch) {
                return true;
            }
        }
        return false;
    }

}


