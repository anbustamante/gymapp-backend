package com.tomandy.ejerciciosapi.repository;

import com.tomandy.ejerciciosapi.dao.EjercicioDao;
import com.tomandy.ejerciciosapi.dto.Exercises;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE, connection = EmbeddedDatabaseConnection.H2)
public class EjerciciosTests {

    @Autowired
    private EjercicioDao ejercicioDao;


    @Test
    public void testSavingEjercicio(){
        ejercicioDao.deleteAll(); /* PARA LIMPIAR LA DB */
        Exercises ejercicio = Exercises.builder().id(20L).nombre("Ejercicio Prueba").descripcion("Descripcion Prueba").build();

        Exercises savedEjercicio = ejercicioDao.save(ejercicio);

        Assertions.assertThat(savedEjercicio).isNotNull();
        Assertions.assertThat(ejercicioDao.findAll()).hasSize( 1);

    }
    @Test
    public void testDeletingEjercicio(){
        Exercises ejercicio = Exercises.builder().id(1L).nombre("Ejercicio Prueba").descripcion("Descripcion Prueba").build();
        ejercicioDao.save(ejercicio);
        int size = ejercicioDao.findAll().size();

        ejercicioDao.delete(ejercicio);

        Optional<Exercises> ejercicioBorrado = ejercicioDao.findById(1L);
        Assertions.assertThat(ejercicioBorrado).isEmpty();
        Assertions.assertThat(ejercicioDao.findAll()).hasSize( size-1);
    }
    @Test
    public void testFindById(){
        Exercises ejercicio = Exercises.builder().id(1L).nombre("Ejercicio Prueba").descripcion("Descripcion Prueba").build();
        ejercicioDao.save(ejercicio);

        Exercises ejercicioGuardado = ejercicioDao.findById(1L).get();

        Assertions.assertThat(ejercicioGuardado.getNombre()).isEqualTo("Ejercicio Prueba");
        Assertions.assertThat(ejercicioGuardado.getDescripcion() ).isEqualTo("Descripcion Prueba");
    }
    @Test
    public void testGetByName(){
        Exercises ejercicio = Exercises.builder().id(1L).nombre("Ejercicio Prueba").descripcion("Descripcion Prueba").build();
        ejercicioDao.save(ejercicio);

        String descripcion = ejercicioDao.getByNombre("Ejercicio Prueba").getDescripcion();

        Assertions.assertThat(descripcion).isEqualTo("Descripcion Prueba");
    }

    @Test
    public void testUpdateEjercicio(){
        Exercises ejercicio = Exercises.builder().id(1L).nombre("Ejercicio Prueba").descripcion("Descripcion Prueba").build();
        ejercicioDao.save(ejercicio);
        int size = ejercicioDao.findAll().size();

        ejercicio.setNombre("Ejercicio Prueba Modificado");
        ejercicio.setDescripcion("Descripcion Prueba Modificada");
        ejercicioDao.save(ejercicio);
        Exercises ejercicioGuardado = ejercicioDao.findById(1L).get();

        Assertions.assertThat(ejercicioDao.findAll()).hasSize(size); // No se agregaron ni se quitaron
        Assertions.assertThat(ejercicioGuardado.getNombre()).isEqualTo("Ejercicio Prueba Modificado");
        Assertions.assertThat(ejercicioGuardado.getDescripcion() ).isEqualTo("Descripcion Prueba Modificada");
    }


}
