package com.example.demo.uiController;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    //Viser startside
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }


}
