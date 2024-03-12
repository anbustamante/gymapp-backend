package com.tomandy.ejerciciosapi.service;

import com.tomandy.ejerciciosapi.dao.PNutricionalDao;
import com.tomandy.ejerciciosapi.dto.PNutricionales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PNutricionalService {

    private PNutricionalDao dao;
    @Autowired
    public PNutricionalService(PNutricionalDao dao) {
        this.dao = dao;
    }

    public List<PNutricionales> getAll() {
        return dao.findAll();
    }

    public String delete(Long id) {
        PNutricionales plan = dao.getById(id);
        if(plan == null){
            return "Plan no encontrado";
        }
        dao.deleteById(id);
        return "Plan eliminado con id: "+id;
    }

    public PNutricionales save(PNutricionales plan) {
        return dao.save(plan);
    }

    public PNutricionales update(PNutricionales plan) {
        return  dao.save(plan);
    }

    public Optional<PNutricionales> getById(Long id) {
        return dao.findById(id);
    }
}


