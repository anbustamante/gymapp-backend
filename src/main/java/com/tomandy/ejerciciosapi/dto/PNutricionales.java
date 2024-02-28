package com.tomandy.ejerciciosapi.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

public class PNutricionales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nutr_id")
    private Long id;
    @Column(name="path")
    private String path;

}
