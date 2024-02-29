package com.tomandy.ejerciciosapi.dao;


import com.tomandy.ejerciciosapi.dto.PNutricionales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PNutricionalDao extends JpaRepository<PNutricionales,Long> {

}
