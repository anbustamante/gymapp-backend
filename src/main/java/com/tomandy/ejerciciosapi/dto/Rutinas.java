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
@Table(name = "routines")
public class Rutinas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rout_id")
    private Long id;
    @Column(name="rout_ex_id")
    private Long ex_id; // Maybe deberia ser publica
    @Column(name="rout_reps")
    private Long repeticiones;
    @Column(name="rout_series")
    private Long series;

}
