package com.tomandy.ejerciciosapi.service;

import com.tomandy.ejerciciosapi.dao.ProfeDao;
import com.tomandy.ejerciciosapi.dto.Profesores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class ProfeService {

    private ProfeDao dao;
    @Autowired
    public ProfeService(ProfeDao dao) {
        this.dao = dao;
    }

    public List<Profesores> getAll() {
        return dao.findAll();
    }

    public Optional<Profesores> getById(String id){
        return dao.findById(Long.valueOf(id));
    }

    public String delete(Long id){
        Profesores prof = dao.getById(id);
        if(isNull(prof)){
            return "Profesor no encontrado";
        }
        dao.deleteById(id);
        return "Profesor eliminado con id: "+id + " Con nombre: " +prof.getNombre() + " " + prof.getApellido();
    }

    public Profesores update(Profesores prof){
        return dao.save(prof);
    }
    public Profesores save(Profesores prof){
        return dao.save(prof);
    }


}


