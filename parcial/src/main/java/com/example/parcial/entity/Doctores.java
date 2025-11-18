package com.example.parcial.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuppressWarnings("deprecation")
@Where(clause = "status = 'active'")
@SQLDelete(sql = "UPDATE contract SET status = false WHERE id = ?")
public class Doctores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String especialidad;
    private String email;
    private Long telefono;
    private Date fecha_contratacion;
    private String status = "active";

    @ManyToOne
    @JoinColumn(name = "clinica_id") 
    private Clinica clinica;   
}
