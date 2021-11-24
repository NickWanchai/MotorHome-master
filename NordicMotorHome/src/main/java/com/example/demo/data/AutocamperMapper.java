package com.example.demo.data;

import com.example.demo.model.Autocamper;
import com.example.demo.model.Rental;

import java.sql.*;
import java.util.ArrayList;

//Mads og emil
public class AutocamperMapper {

    //Tilføjer autocamper til databasen
    public void addAutocamper(Autocamper autocamper) {
        try {
            Connection connection = DBConnectionManager.getConnection();
            String SQL = "INSERT INTO autocamper VALUES(DEFAULT, ?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, autocamper.getModel());
            ps.setString(2, autocamper.getBrand());
            ps.setInt(3, autocamper.getCapacity());
            ps.setInt(4, autocamper.getManufacturingYear());
            ps.setInt(5, autocamper.getRentalPrice());
            ps.setString(6, autocamper.getFuelType());
            ps.setString(7, autocamper.getTowHitch());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //returnerer arrayliste med alle autocampers fra databasen
    public ArrayList<Autocamper> getAllAutocampers() {
        ArrayList<Autocamper> auto = new ArrayList<>();

        try {
            Connection connection = DBConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM autocamper";
            ResultSet rs = statement.executeQuery(sql);
            int id;
            String model;
            String brand;
            int capacity;
            int manufacturingYear;
            int rentalPrice;
            String fuelType;
            String towHitch;
            Autocamper autocamper;

            while (rs.next()) {
                id = rs.getInt("autocamper_id");
                model = rs.getString("model");
                brand = rs.getString("brand");
                capacity = rs.getInt("capacity");
                manufacturingYear = rs.getInt("manufacturing_year");
                rentalPrice = rs.getInt("rental_price");
                fuelType = rs.getString("fuel_type");
                towHitch = rs.getString("tow_hitch");
                autocamper = new Autocamper(id, model, brand, capacity, manufacturingYear, rentalPrice, fuelType, towHitch);
                auto.add(autocamper);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return auto;
    }

    //Returnerer autocamper der har id'et fra metodens parameter
    public Autocamper findAutocamper(int idSearch) {
        Autocamper autocamper = null;

        try {
            Connection connection = DBConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM autocamper";
            ResultSet rs = statement.executeQuery(sql);
            int id;
            String model;
            String brand;
            int capacity;
            int manufacturingYear;
            int rentalPrice;
            String fuelType;
            String towHitch;

            while (rs.next()) {
                id = rs.getInt("autocamper_Id");
                model = rs.getString("model");
                brand = rs.getString("brand");
                capacity = rs.getInt("capacity");
                manufacturingYear = rs.getInt("manufacturing_year");
                rentalPrice = rs.getInt("rental_price");
                fuelType = rs.getString("fuel_type");
                towHitch = rs.getString("tow_hitch");
                if (id == idSearch) {
                    return new Autocamper(id, model, brand, capacity, manufacturingYear, rentalPrice, fuelType, towHitch);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return autocamper;
    }

    //Sletter autocamper fra database
    public void deleteAutocamper(int id) {
        try {
            Connection connection = DBConnectionManager.getConnection();
            String sql = "DELETE FROM autocamper WHERE autocamper_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
