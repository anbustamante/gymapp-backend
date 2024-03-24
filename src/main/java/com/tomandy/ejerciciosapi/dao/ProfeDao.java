package com.tomandy.ejerciciosapi.dao;


import com.tomandy.ejerciciosapi.dto.Profesores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfeDao extends JpaRepository<Profesores,Long> {

}

