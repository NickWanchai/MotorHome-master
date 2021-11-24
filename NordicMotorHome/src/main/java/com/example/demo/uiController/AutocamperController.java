package com.example.demo.uiController;

import com.example.demo.model.SystemController;
import com.example.demo.model.Autocamper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AutocamperController {

    private SystemController sController = new SystemController();

    //viser liste over alle autocampers
    @GetMapping("/autocamper")
    public String autocamper(Model model) {
        model.addAttribute("autocampers", sController.getAllAutocampers());
        return "autocamper";
    }

    //Kommer til siden hvor autocamper info skrives ind
    @GetMapping("/addAuto")
    public String addAuto(Model model) {
        model.addAttribute("autocamper", new Autocamper());
        return "addAutocamper";
    }

    //Tilføjer ny autocamper til vores database
    @PostMapping("/addAuto")
    public String addAuto(HttpServletRequest request) {
        String model = request.getParameter("model");
        String brand = request.getParameter("brand");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        int manufacturingYear = Integer.parseInt(request.getParameter("manufacturingYear"));
        int rentalPrice = Integer.parseInt(request.getParameter("rentalPrice"));
        String fuel = request.getParameter("fuelType");
        String tow = request.getParameter("towHitch");

        Autocamper autocamper = new Autocamper(model, brand, capacity, manufacturingYear, rentalPrice, fuel, tow);
        sController.addAutocamper(autocamper);
        return "redirect:/autocamper";
    }

    //viser liste over alle autocampers
    @GetMapping("/equipment")
    public String autocamper() {
        return "equipment";
    }
}
