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
@Table(name = "profs")
public class Profesores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prof_id")
    private Long id;
    @Column(name="prof_name")
    private String nombre;
    @Column(name="prof_lastname")
    private String apellido;

}
