package com.tomandy.ejerciciosapi.dao;


import com.tomandy.ejerciciosapi.dto.Exercises;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjercicioDao extends JpaRepository<Exercises,Long> {

}
