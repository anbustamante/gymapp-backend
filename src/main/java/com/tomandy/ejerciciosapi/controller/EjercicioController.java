package com.tomandy.ejerciciosapi.controller;

import com.tomandy.ejerciciosapi.dto.Exercises;
import com.tomandy.ejerciciosapi.service.EjercicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EjercicioController {//Holamou
    private EjercicioService service;
    @Autowired
    public EjercicioController(EjercicioService service) {
        this.service = service;
    }

    @GetMapping("/ejercicio")
    public ResponseEntity<List<Exercises>> getEjercicioDTO(){//HOLALOGICA

        return ResponseEntity.ok(service.getAll());
         }
    @DeleteMapping("/ejercicio/{id}")
    public ResponseEntity<String> deleteEjercicio(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
    @GetMapping("/ejercicio/{id}")
    public ResponseEntity<Optional<Exercises>> getEjercicioById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }
    @PostMapping("/ejercicio")
    public  ResponseEntity<Exercises> saveEjercicio(@RequestBody Exercises ejercicio){
        return ResponseEntity.ok(service.save(ejercicio));
    }
    @PutMapping("/ejercicio")
    public  ResponseEntity<Exercises> updateEjercicio(@RequestBody Exercises ejercicio){
        return ResponseEntity.ok(service.update(ejercicio));
    }
}
