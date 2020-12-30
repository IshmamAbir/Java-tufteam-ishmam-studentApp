package com.example.tufteamishmam.controller;

import com.example.tufteamishmam.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Controller
@RequestMapping("/city")
public class CityController implements Serializable {

    CityService service;

    public CityController(CityService service) {
        this.service = service;
    }

    @GetMapping("/show-all")
    public String showAllCity(Model model){
        model.addAttribute("cityDtoList",service.showAllCity());

        return "city/show-city";
    }

    @GetMapping("/add")
    public String addNewCity(){


        return "city/add-city";
    }

}
