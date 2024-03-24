package com.tomandy.ejerciciosapi.repository;

import com.tomandy.ejerciciosapi.dao.ProfeDao;
import com.tomandy.ejerciciosapi.dto.Profesores;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE, connection = EmbeddedDatabaseConnection.H2)
public class ProfesoresTests {

    @Autowired
    private ProfeDao dao;


    @Test
    public void testSavingProfesor(){
        dao.deleteAll(); /* PARA LIMPIAR LA DB */

        Profesores prof = Profesores.builder().nombre("Nombre Prueba").apellido("Apellido Prueba").build();

        dao.save(prof);

        Assertions.assertThat(dao.findById(prof.getId())).isNotNull();
        Assertions.assertThat(dao.findAll()).hasSize(1);

    }
    @Test
    public void testFindById(){
        Profesores prof = Profesores.builder().nombre("Nombre Prueba").apellido("Apellido Prueba").build();
        dao.save(prof);

        Profesores profGuardado = dao.findById(prof.getId()).get();

        Assertions.assertThat(profGuardado.getNombre()).isEqualTo("Nombre Prueba");
        Assertions.assertThat(profGuardado.getApellido() ).isEqualTo("Apellido Prueba");
    }

    @Test
    public void testDeletingProfesor(){
        Profesores prof = Profesores.builder().nombre("Nombre Prueba").apellido("Apellido Prueba").build();
        dao.save(prof);
        int size = dao.findAll().size();

        dao.delete(prof);

        Optional<Profesores> profBorrado = dao.findById(prof.getId());
        Assertions.assertThat(profBorrado).isEmpty();
        Assertions.assertThat(dao.findAll()).hasSize( size-1);
    }


    @Test
    public void testUpdateProfesor(){
        Profesores prof = Profesores.builder().nombre("Nombre Prueba").apellido("Apellido Prueba").build();
        Profesores savedPfesor = dao.save(prof);
        Long id = savedPfesor.getId();
        int size = dao.findAll().size();

        savedPfesor.setNombre("Nombre de Prueba Modificado");
        savedPfesor.setApellido("Apellido de Prueba Modificado");
        dao.save(savedPfesor);
        Profesores profesorGuardado = dao.findById(id).get();

        Assertions.assertThat(dao.findAll()).hasSize(size);
        Assertions.assertThat(profesorGuardado).isNotNull();
        Assertions.assertThat(profesorGuardado.getNombre()).isEqualTo("Nombre de Prueba Modificado");
        Assertions.assertThat(profesorGuardado.getApellido()).isEqualTo("Apellido de Prueba Modificado");
    }


}
