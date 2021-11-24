package com.example.demo.uiController;

import com.example.demo.model.SystemController;
import com.example.demo.exceptions.RentAutocamperException;
import com.example.demo.model.Rental;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
public class RentalController {

    private SystemController sController = new SystemController();


    //viser side over udlejninger
    @GetMapping("/rentals")
    public String rentals(Model model) {
        model.addAttribute("rentals", sController.getAllRentals());
        return "rentals";
    }

    //Viser sider hvor udlejning kan oprettes
    @GetMapping("/addRental")
    public String addRental(Model model) {
        //klargør tomt objekt, som addCustomer.html skal bruge
        model.addAttribute("rental", new Rental());
        model.addAttribute("autocampers", sController.getAllAutocampers());
        model.addAttribute("customers", sController.getAllCustomers());
        return "addRental";
    }

    //opretter udlejning
    @PostMapping("/addRental")
    public String addRental(HttpServletRequest request) throws RentAutocamperException {

        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int autocamperId = Integer.parseInt(request.getParameter("autocamperId"));
        String date = request.getParameter("dateOfRent");
        LocalDate dateOfRent = convertDate(date);
        Rental rental = new Rental(customerId, autocamperId, dateOfRent);


        if (sController.checkForAutocamperAvailability(autocamperId)) {
            throw new RentAutocamperException("Autocamper is rented!");
        } else if (!sController.findAutocamperId(autocamperId)) {
            throw new RentAutocamperException("Autocamper id does not exist");
        } else if (sController.checkForCustomerAvailability(customerId)) {
            throw new RentAutocamperException("customer is currently renting");
        } else if (!sController.findCustomerId(customerId)) {
            throw new RentAutocamperException("Customer id does not exist");
        } else {
            sController.addRental(rental);
            return "redirect:/rentals";
        }
    }

    //Håndtere exceptions
    @ExceptionHandler(RentAutocamperException.class)
    public String rentAutocamperException(Model model, Exception exception) {
        model.addAttribute("message", exception.getMessage());
        return "rentAutocamperException";
    }

    //Laver String om til LocalDate
    public LocalDate convertDate(String date) {

        String split[] = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return LocalDate.of(year, month, day);
    }

    //viser side over udlejninger
    @GetMapping("/headerTest")
    public String headerTest() {
        return "header";
    }


}
