package com.example.parcial.service;
import com.example.parcial.entity.Clinica;
import com.example.parcial.entity.Doctores;
import com.example.parcial.dto.DoctoresDTO;
import com.example.parcial.repository.DoctoresRepository; 

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctoresService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private DoctoresRepository doctoresRepository;


    public DoctoresDTO createDoctores(DoctoresDTO dto) {

        Doctores doctores = new Doctores();

        doctores.setNombre(dto.getNombre());
        doctores.setEspecialidad(dto.getEspecialidad());
        doctores.setEmail(dto.getEmail());
        doctores.setTelefono(dto.getTelefono());
        doctores.setFecha_contratacion(dto.getFecha_contratacion());
        doctores.setStatus(dto.getStatus() != null ? dto.getStatus() : "active");

        doctoresRepository.save(doctores);

        return modelMapper.map(doctores, DoctoresDTO.class);
    }


   
    public DoctoresDTO updateDoctores(Long id, DoctoresDTO dto) {

        Doctores doctores = findById(id);

        if (dto.getNombre() != null) doctores.setNombre(dto.getNombre());
        if (dto.getEspecialidad() != null) doctores.setEspecialidad(dto.getEspecialidad());
        if (dto.getEmail() != null) doctores.setEmail(dto.getEmail());
        if (dto.getTelefono() != null) doctores.setTelefono(dto.getTelefono());
        if (dto.getFecha_contratacion() != null) doctores.setFecha_contratacion(dto.getFecha_contratacion());
        if (dto.getStatus() != null) doctores.setStatus(dto.getStatus());

        doctoresRepository.save(doctores);

        return modelMapper.map(doctores, DoctoresDTO.class);
    }



    public DoctoresDTO findById(Long id) {
        return doctoresRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctores no encontrados"));
    }

    public DoctoresDTO findDoctoresDTO(Long id) {

        Doctores doctores = findById(id);

        DoctoresDTO dto = modelMapper.map(doctores, DoctoresDTO.class);
        
        return dto;
    }

    public List<DoctoresDTO> findDoctoresDTOs() {
        return doctoresRepository.findAll()
                .stream()
                .map(doctores -> modelMapper.map(doctores, DoctoresDTO.class))
                .collect(Collectors.toList());
    }

    
    public void deleteDoctores(Long id) {

        Doctores doctores = findById(id);

        doctores.setStatus("deleted");
        doctoresRepository.save(doctores);
    }
}
