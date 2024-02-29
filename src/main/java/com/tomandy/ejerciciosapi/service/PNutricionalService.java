package com.tomandy.ejerciciosapi.service;

import com.tomandy.ejerciciosapi.dao.PNutricionalDao;
import com.tomandy.ejerciciosapi.dto.PNutricionales;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}


