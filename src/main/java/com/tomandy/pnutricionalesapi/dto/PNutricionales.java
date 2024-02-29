package com.tomandy.pnutricionalesapi.dto;

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
    @Column(name="nutr_path")
    private String path;

}
