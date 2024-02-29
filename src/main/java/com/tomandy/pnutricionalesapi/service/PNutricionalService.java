package com.tomandy.pnutricionalesapi.service;

import com.tomandy.pnutricionalesapi.dao.PNutricionalDao;
import com.tomandy.pnutricionalesapi.dto.PNutricionales;
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


