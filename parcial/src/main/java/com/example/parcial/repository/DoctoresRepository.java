package com.example.parcial.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.parcial.entity.Clinica;

public interface DoctoresRepository extends JpaRepository<Clinica, Long> {
    
}
