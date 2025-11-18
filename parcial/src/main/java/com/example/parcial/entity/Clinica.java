package com.example.parcial.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuppressWarnings("deprecation")
@Where(clause = "status = 'active'")
@SQLDelete(sql = "UPDATE entity SET status = false WHERE id = ?")
public class Clinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direccion;
    private String nombre;
    private Integer cantidad_camaras;
    private Long telefono;
    private String ciudad;
    private Date fecha_creacion;
    private String status = "active";

    @OneToMany(mappedBy = "doctores") 
    private List<Doctores> doctors;
}
