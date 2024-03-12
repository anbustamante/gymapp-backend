package com.tomandy.ejerciciosapi.controller;

import com.tomandy.ejerciciosapi.dto.PNutricionales;
import com.tomandy.ejerciciosapi.service.PNutricionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PNutricionalController {
    private PNutricionalService service;
    @Autowired
    public PNutricionalController(PNutricionalService service) {
        this.service = service;
    }

    @GetMapping("/p_nutricionales")
    public List<PNutricionales> getPNutricionalDTO(){
        return service.getAll();
         }
    @GetMapping("/p_nutricionales/{id}")
    public ResponseEntity<Optional<PNutricionales>> getPNutricionalById(@PathVariable Long id){
        return ResponseEntity.ok(service.getById(id));
    }
    @DeleteMapping("/p_nutricionales/{id}")
    public ResponseEntity<String> deletePNutricional(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
    @PostMapping("/p_nutricionales")
    public  ResponseEntity<PNutricionales> savePNutricional(@RequestBody PNutricionales plan){
        return ResponseEntity.ok(service.save(plan));
    }
    @PutMapping("/p_nutricionales")
    public  ResponseEntity<PNutricionales> updatePNutricional(@RequestBody PNutricionales plan){
        return ResponseEntity.ok(service.update(plan));
    }


}
