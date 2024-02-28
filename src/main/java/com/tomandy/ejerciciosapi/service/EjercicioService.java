package com.tomandy.ejerciciosapi.service;

import com.tomandy.ejerciciosapi.dao.EjercicioDao;
import com.tomandy.ejerciciosapi.dto.Exercises;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}


