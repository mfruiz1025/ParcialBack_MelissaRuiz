package com.example.parcial.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClinicaDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private Integer cantidad_camaras;
    private Long telefono;
    private String ciudad;
    private Date fecha_creacion;
    private String status = "active";

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Long doctoresId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String doctores;
}
