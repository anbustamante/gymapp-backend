package com.tomandy.ejerciciosapi.controller;

import com.tomandy.ejerciciosapi.dto.Profesores;
import com.tomandy.ejerciciosapi.service.ProfeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProfeController {
    private ProfeService service;

    @Autowired
    public ProfeController(ProfeService service) {
        this.service = service;
    }

    @GetMapping("/profesor")
    public ResponseEntity<List<Profesores>> getProfesorDTO(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/profesor/{id}")
    public ResponseEntity<Optional<Profesores>> getProfesorById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/profesor/{id}")
    public ResponseEntity<String> deleteProfesor(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @PostMapping("/profesor")
    public  ResponseEntity<Profesores> saveProfesor(@RequestBody Profesores prof){
        return ResponseEntity.ok(service.save(prof));
    }
    @PutMapping("/profesor")
    public  ResponseEntity<Profesores> updateProfesor(@RequestBody Profesores prof){
        return ResponseEntity.ok(service.update(prof));
    }

}
