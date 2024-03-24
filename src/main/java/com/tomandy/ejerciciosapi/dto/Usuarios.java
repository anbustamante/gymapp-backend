package com.tomandy.ejerciciosapi.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class Usuarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;
    @Column(name="user_name")
    private String nombre;
    @Column(name="user_lastname")
    private String apellido;
    @Column(name="user_email")
    private String email;
    @Column(name="user_routin_id")
    private Long rutinaId;
    @Column(name="user_nutr_id")
    private Long nutrId;
    @Column(name="user_prof_id")
    private Long profId;
    @Column(name="user_fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name="user_fecha_ingreso")
    private Date fechaIngreso;
    @Column(name="user_fecha_vencimiento")
    private Date fechaVencimiento;
    @Column(name="user_active")
    private boolean active = true; //por defecto es true


}

