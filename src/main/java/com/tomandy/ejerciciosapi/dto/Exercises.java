package com.tomandy.ejerciciosapi.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "exercises")
public class Exercises {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ex_id")
    private Long id;
    @Column(name="ex_name")
    private String nombre;
    @Column(name="ex_desc")
    private String descripcion;

}
