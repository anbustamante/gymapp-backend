package com.tomandy.ejerciciosapi.controller;

import com.tomandy.ejerciciosapi.dto.Usuarios;
import com.tomandy.ejerciciosapi.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuarioController {
    private UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuario")
    public ResponseEntity<List<Usuarios>> getUsuarioDTO(){
        return ResponseEntity.ok(service.getAll());
    }
    
    @GetMapping("/usuario/{id}")
    public ResponseEntity<Optional<Usuarios>> getUsuarioById(@PathVariable String id){
        return ResponseEntity.ok(service.getById(id));
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @PostMapping("/usuario")
    public  ResponseEntity<Usuarios> saveUsuario(@RequestBody Usuarios user){
        return ResponseEntity.ok(service.save(user));
    }
    @PutMapping("/usuario")
    public  ResponseEntity<Usuarios> updateUsuario(@RequestBody Usuarios user){
        return ResponseEntity.ok(service.update(user));
    }
}
