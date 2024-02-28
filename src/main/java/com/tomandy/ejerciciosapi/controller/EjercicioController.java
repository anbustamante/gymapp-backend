package com.tomandy.ejerciciosapi.controller;

import com.tomandy.ejerciciosapi.dto.Exercises;
import com.tomandy.ejerciciosapi.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EjercicioController {//Holamou
    private EjercicioService service;
    @Autowired
    public EjercicioController(EjercicioService service) {
        this.service = service;
    }

    @GetMapping("/ejercicio")
    public List<Exercises> getEjercicioDTO(){//HOLALOGICA

        return service.getAll();
         }

}
