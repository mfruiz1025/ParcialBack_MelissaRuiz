package com.example.parcial.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parcial.dto.ClinicaDTO;
import com.example.parcial.entity.Clinica;
import com.example.parcial.repository.ClinicaRepository;
import com.example.parcial.entity.Doctores;
import com.example.parcial.service.DoctoresService;


@Service
public class ClinicaService {

    @Autowired
    private ClinicaRepository clinicaRepository;

    @Autowired
    private DoctoresService doctoresService;

    @Autowired
    private ModelMapper modelMapper;

    public ClinicaDTO findClinica(Long id){
        Clinica clinica = clinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clinica no encontrada"));

        ClinicaDTO dto = modelMapper.map(clinica, ClinicaDTO.class);
        dto.setDoctores(clinica.getDoctores().getNombre());
        return dto;
    }
   
    public List<ClinicaDTO> findClinicas() {
        return clinicaRepository.findAll().stream()
                .map(clinica -> {
                    ClinicaDTO dto = modelMapper.map(clinica, ClinicaDTO.class);
                    dto.setDoctores(clinica.getDoctores().getNombre());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public ClinicaDTO createClinica(ClinicaDTO dto){
        if(dto.getDoctoresId() == null){
            throw new RuntimeException("El ID del doctor es obligatorio");
        }

        Doctores doctores = doctoresService.findById(dto.getDoctoresId());

        Clinica clinica = modelMapper.map(dto, Clinica.class);
        clinica.setDoctores(doctores);
        clinica.setStatus(dto.getStatus() != null ? dto.getStatus() : "active");
        
        clinicaRepository.save(clinica);

        ClinicaDTO response = modelMapper.map(clinica, ClinicaDTO.class);
        response.setDoctores(doctores.getNombre());

        return response;
    }


    public ClinicaDTO updateClinica(Long id, ClinicaDTO dto) {
        Clinica clinica = clinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clinica no encontrada"));

        if (dto.getNombre() != null) clinica.setNombre(dto.getNombre());
        if (dto.getDireccion() != null) clinica.setDireccion(dto.getDireccion());
        if (dto.getCantidad_camaras() != null) clinica.setCantidad_camaras(dto.getCantidad_camaras());
        if (dto.getTelefono() != null) clinica.setTelefono(dto.getTelefono());
        if (dto.getCiudad() != null) clinica.setCiudad(dto.getCiudad());
        if (dto.getFecha_creacion() != null) clinica.setFecha_creacion(dto.getFecha_creacion());
        if (dto.getStatus() != null) clinica.setStatus(dto.getStatus());

        if (dto.getDoctoresId() != null) {
            Doctores doctores = doctoresService.findById(dto.getDoctoresId());
            clinica.setDoctores(doctores);
        }

        clinicaRepository.save(clinica);

        ClinicaDTO response = modelMapper.map(clinica, ClinicaDTO.class);
        response.setDoctores(clinica.getDoctores().getNombre());

        return response;
    }

    public void deleteClinica(Long id) {
        Clinica clinica = clinicaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clinica no encontrada"));

        clinica.setStatus("deleted");  
        clinicaRepository.save(clinica);
    }


}
