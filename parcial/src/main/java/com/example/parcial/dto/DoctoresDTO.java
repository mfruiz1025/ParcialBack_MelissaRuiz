package com.example.parcial.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Date;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DoctoresDTO {
    private Long id;
    private String nombre;
    private String especialidad;
    private String email;
    private Long telefono;
    private Date fecha_contratacion;
    private String status;

    @JsonIgnore()
    private List<ClinicaDTO> clinicas;   
}
