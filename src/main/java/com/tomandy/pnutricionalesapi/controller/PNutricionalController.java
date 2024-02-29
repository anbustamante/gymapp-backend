package com.tomandy.pnutricionalesapi.controller;

import com.tomandy.pnutricionalesapi.dto.PNutricionales;
import com.tomandy.pnutricionalesapi.service.PNutricionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PNutricionalController {//Holamou
    private PNutricionalService service;
    @Autowired
    public PNutricionalController(PNutricionalService service) {
        this.service = service;
    }

    @GetMapping("/p_nutricional")
    public List<PNutricionales> getPNutricionalDTO(){

        return service.getAll();
         }

}
