package com.tomandy.pnutricionalesapi.dao;


import com.tomandy.pnutricionalesapi.dto.PNutricionales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PNutricionalDao extends JpaRepository<PNutricionales,Long> {

}
