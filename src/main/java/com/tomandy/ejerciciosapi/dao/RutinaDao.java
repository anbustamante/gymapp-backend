package com.tomandy.ejerciciosapi.dao;


import com.tomandy.ejerciciosapi.dto.Rutinas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RutinaDao extends JpaRepository<Rutinas,Long> {

}

