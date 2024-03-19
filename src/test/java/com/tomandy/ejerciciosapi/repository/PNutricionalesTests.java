package com.tomandy.ejerciciosapi.repository;


import com.tomandy.ejerciciosapi.dao.PNutricionalDao;
import com.tomandy.ejerciciosapi.dto.PNutricionales;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE, connection = EmbeddedDatabaseConnection.H2)
public class PNutricionalesTests {

    @Autowired
    private PNutricionalDao PNutrDao;


    @Test
    public void testSavingPNutricional(){
        PNutrDao.deleteAll(); /* PARA LIMPIAR LA DB */
        PNutricionales plan = PNutricionales.builder().id(20L).path("Path Prueba").build();

        PNutricionales savedPlan = PNutrDao.save(plan);

        Assertions.assertThat(savedPlan).isNotNull();
        Assertions.assertThat(PNutrDao.findAll()).hasSize( 1);

    }
    @Test
    public void testDeletingPNutricional(){

        PNutricionales plan = PNutricionales.builder().id(20L).path("Path Prueba").build();

        PNutricionales savedPlan = PNutrDao.save(plan);
        int size = PNutrDao.findAll().size();
        PNutrDao.delete(savedPlan);

        Optional<PNutricionales> planBorrado = PNutrDao.findById(20L);
        Assertions.assertThat(planBorrado).isEmpty();
        Assertions.assertThat(PNutrDao.findAll()).hasSize( size - 1);
    }
    @Test
    public void testFindById(){

        PNutricionales plan = PNutricionales.builder().id(20L).path("Path Prueba").build();
        PNutricionales planGuardado = PNutrDao.save(plan);


        Optional<PNutricionales> buscado = PNutrDao.findById(planGuardado.getId());
        PNutricionales planBuscado = buscado.get();

        Assertions.assertThat(planBuscado.getPath()).isEqualTo("Path Prueba");
    }
    @Test
    public void testUpdatePNutricional(){
        PNutricionales plan = PNutricionales.builder().path("Path Prueba").build();
        PNutricionales savedPlan = PNutrDao.save(plan);
        Long id = savedPlan.getId(); // Obtener el ID del plan nutricional guardado
        int size = PNutrDao.findAll().size();

        savedPlan.setPath("Path de Prueba Modificado");
        PNutrDao.save(savedPlan);
        PNutricionales planGuardado = PNutrDao.findById(id).get();

        Assertions.assertThat(PNutrDao.findAll()).hasSize(size); // No se agregaron ni se quitaron
        Assertions.assertThat(planGuardado).isNotNull();
        Assertions.assertThat(planGuardado.getPath()).isEqualTo("Path de Prueba Modificado");
    }


}
