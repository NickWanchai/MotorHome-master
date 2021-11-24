package com.example.demo;

import com.example.demo.data.AutocamperMapper;
import com.example.demo.data.CustomerMapper;
import com.example.demo.model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws NullPointerException {
        SpringApplication.run(DemoApplication.class, args);

    }

}
