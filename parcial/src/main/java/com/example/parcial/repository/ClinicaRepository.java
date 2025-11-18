package com.example.parcial.repository;
import  com.example.parcial.entity.Doctores;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicaRepository extends JpaRepository<Doctores, Long>{

}
