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
@Table(name = "p_nutricionales")
public class PNutricionales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nutr_id")
    private Long id;
    @Column(name="path")
    private String path;



}

