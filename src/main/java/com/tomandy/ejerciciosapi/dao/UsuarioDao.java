package com.tomandy.ejerciciosapi.dao;


import com.tomandy.ejerciciosapi.dto.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuarios,Long> {

}

