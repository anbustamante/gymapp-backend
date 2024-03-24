package com.tomandy.ejerciciosapi.controller;


import com.tomandy.ejerciciosapi.dto.Rutinas;
import com.tomandy.ejerciciosapi.service.RutinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RutinaController {
    private RutinaService service;

    @Autowired
    public RutinaController(RutinaService service) {
        this.service = service;
    }

    @GetMapping("/rutina")
    public ResponseEntity<List<Rutinas>> getRutinaDTO(){
        return ResponseEntity.ok(service.getAll());
    }
    
    @GetMapping("/rutina/{id}")
    public ResponseEntity<Optional<Rutinas>> getRutinaById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/rutina/{id}")
    public ResponseEntity<String> deleteRutina(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @PostMapping("/rutina")
    public  ResponseEntity<Rutinas> saveRutina(@RequestBody Rutinas ruti){
        return ResponseEntity.ok(service.save(ruti));
    }
    @PutMapping("/rutina")
    public  ResponseEntity<Rutinas> updateRutina(@RequestBody Rutinas ruti){
        return ResponseEntity.ok(service.update(ruti));
    }
}
