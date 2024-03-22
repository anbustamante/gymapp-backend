package com.tomandy.ejerciciosapi.service;

import com.tomandy.ejerciciosapi.dao.RutinaDao;
import com.tomandy.ejerciciosapi.dto.Rutinas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
public class RutinaService {

    private RutinaDao dao;
    @Autowired
    public RutinaService(RutinaDao dao) {
        this.dao = dao;
    }

    public List<Rutinas> getAll() {
        return dao.findAll();
    }

    public Optional<Rutinas> getById(String id){
        return dao.findById(Long.valueOf(id));
    }

    public String delete(Long id){
        Rutinas rut = dao.getById(id);
        if(isNull(rut)){
            return "Rutina no encontrada";
        }
        dao.deleteById(id);
        return "Rutina eliminada con id: "+id;
    }

    public Rutinas update(Rutinas rut){
        return dao.save(rut);
    }
    public Rutinas save(Rutinas rut){
        return dao.save(rut);
    }


}


