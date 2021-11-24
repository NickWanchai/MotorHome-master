package com.example.demo.uiController;


import com.example.demo.model.SystemController;
import com.example.demo.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;


@Controller
public class CustomerController {

    private SystemController sController = new SystemController();

    //Viser liste med alle kunder
    @GetMapping("/customers")
    public String customers(Model model) {
        model.addAttribute("customers", sController.getAllCustomers());
        return "customers";
    }

    //kommer til siden hvor info om ny kunde indstastes
    @GetMapping("/addCustomer")
    public String addCustomer(Model model) {
        //klargør tomt objekt, som addCustomer.html skal bruge
        model.addAttribute("customer", new Customer());
        return "addCustomer";
    }

    //Tilføjer ny kunde til databasen
    @PostMapping("/addCustomer")
    public String addCustomer(HttpServletRequest request) {
        String fn = request.getParameter("firstName");
        String ln = request.getParameter("lastName");
        String date = request.getParameter("birthday");
        LocalDate birthday = convertDate(date);
        String email = request.getParameter("email");
        int zipCode = Integer.parseInt(request.getParameter("zipCode"));
        String adress = request.getParameter("adress");
        int phonenumber = Integer.parseInt(request.getParameter("phonenumber"));
        Customer customer = new Customer(fn, ln, birthday, email, zipCode, adress, phonenumber);
        sController.addCustomer(customer);
        return "redirect:/customers";
    }


    //Side der viser liste over alle kunder og en delete knap
    @GetMapping("/delete")
    public String delete(Model model) {
        model.addAttribute("customers", sController.getAllCustomers());
        return "deleteCustomer";
    }

    //Side hvor slet kunde fra databasen skal bekræftes
    @GetMapping("/verifyDelete")
    public String verifyDelete(@RequestParam("id") int id, Model model) {
        model.addAttribute("customer", sController.findCustomer(id));
        return "verifyCustomerDelete";
    }

    //metode der sletter kunde fra database
    @PostMapping("/verifyDelete")
    public String verifyDelete(HttpServletRequest request) {
        String id = request.getParameter("id");
        sController.deleteCustomer(Integer.parseInt(id));
        return "redirect:/";
    }

    //Laver String om til LocalDate
    public LocalDate convertDate(String date) {

        String split[] = date.split("-");
        int year = Integer.parseInt(split[0]);
        int month = Integer.parseInt(split[1]);
        int day = Integer.parseInt(split[2]);
        return LocalDate.of(year, month, day);
    }


}
