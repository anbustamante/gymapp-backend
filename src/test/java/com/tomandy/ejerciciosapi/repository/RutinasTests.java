package com.tomandy.ejerciciosapi.repository;


import com.tomandy.ejerciciosapi.dao.RutinaDao;
import com.tomandy.ejerciciosapi.dto.Rutinas;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE, connection = EmbeddedDatabaseConnection.H2)
public class RutinasTests {

    @Autowired
    private RutinaDao dao;



    @Test
    public void testSavingRutina(){
        dao.deleteAll(); /* PARA LIMPIAR LA DB */

        Rutinas rutin = Rutinas.builder().ex_id(2L).repeticiones(10L).series(3L).build();

        dao.save(rutin);

        Assertions.assertThat(dao.findById(rutin.getId())).isNotNull();
        Assertions.assertThat(dao.findAll()).hasSize(1);

    }
    @Test
    public void testFindById(){
        Rutinas rutin = Rutinas.builder().ex_id(2L).repeticiones(10L).series(3L).build();
        dao.save(rutin);

        Rutinas rutGuardada = dao.findById(rutin.getId()).get();

        Assertions.assertThat(rutGuardada.getEx_id()).isEqualTo(2L);
        Assertions.assertThat(rutGuardada.getRepeticiones()).isEqualTo(10L);
        Assertions.assertThat(rutGuardada.getSeries()).isEqualTo(3L);

    }

    @Test
    public void testDeletingRutina(){
        Rutinas rutin = Rutinas.builder().ex_id(2L).repeticiones(10L).series(3L).build();
        dao.save(rutin);
        int size = dao.findAll().size();

        dao.delete(rutin);

        Optional<Rutinas> deleted = dao.findById(rutin.getId());
        Assertions.assertThat(deleted).isEmpty();
        Assertions.assertThat(dao.findAll()).hasSize( size-1);
    }


    @Test
    public void testUpdateRutina(){
        Rutinas rutin = Rutinas.builder().ex_id(2L).repeticiones(10L).series(3L).build();
        Rutinas saved = dao.save(rutin);
        Long id = saved.getId();
        int size = dao.findAll().size();

        saved.setRepeticiones(20L);
        saved.setSeries(2L);
        dao.save(saved);
        Rutinas rutGuardada = dao.findById(id).get();

        Assertions.assertThat(dao.findAll()).hasSize(size);
        Assertions.assertThat(rutGuardada).isNotNull();
        Assertions.assertThat(rutGuardada.getRepeticiones()).isEqualTo(20L);
        Assertions.assertThat(rutGuardada.getSeries()).isEqualTo(2L);
        System.out.println(dao.findAll());

    }


}
