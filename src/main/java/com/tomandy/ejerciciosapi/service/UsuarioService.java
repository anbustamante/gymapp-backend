package com.tomandy.ejerciciosapi.service;

import com.tomandy.ejerciciosapi.dao.UsuarioDao;
import com.tomandy.ejerciciosapi.dto.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioDao dao;
    @Autowired
    public UsuarioService(UsuarioDao dao) {
        this.dao = dao;
    }

    public List<Usuarios> getAll() {
        return dao.findAll();
    }

    public Optional<Usuarios> getById(String id){
        return dao.findById(Long.valueOf(id));
    }

    public String delete(Long id){
        Usuarios user = dao.getById(id);
        if(user == null){
            return "Usuario no encontrado";
        }
        dao.deleteById(id);
        return "Usuario eliminado con id: "+id + " Con nombre: " +user.getNombre() + " " + user.getApellido();
    }

    public Usuarios update(Usuarios user){
        return dao.save(user);
    }
    public Usuarios save(Usuarios user){
        return dao.save(user);
    }

}


