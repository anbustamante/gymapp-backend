package com.tomandy.ejerciciosapi.service;

import com.tomandy.ejerciciosapi.dao.EjercicioDao;
import com.tomandy.ejerciciosapi.dto.Exercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EjercicioService {

    private EjercicioDao dao;
    @Autowired
    public EjercicioService(EjercicioDao dao) {
        this.dao = dao;
    }

    public List<Exercises> getAll() {
        return dao.findAll();
    }

    public Optional<Exercises> getById(String id){
        return dao.findById(Long.valueOf(id));
    }

    public String delete(Long id){
        Exercises ejercicio = dao.getById(id);
        if(ejercicio==null){
            return "Ejercicio no encontrado";
        }
        dao.deleteById(id);
        return "Ejercicio eliminado con id: "+id + " Con nombre: " +ejercicio.getNombre();
    }

    public Exercises update(Exercises ejercicio){
        return dao.save(ejercicio);
    }
    public Exercises save(Exercises ejercicio){
        return dao.save(ejercicio);
    }




}


