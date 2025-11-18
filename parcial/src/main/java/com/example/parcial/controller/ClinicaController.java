package com.example.parcial.controller;

import com.example.parcial.service.ClinicaService;
import com.example.parcial.dto.ClinicaDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api/clinicas")
public class ClinicaController {

    @Autowired
    private ClinicaService clinicaService;
    
    @PostMapping()
    public ClinicaDTO createClinica(@RequestBody ClinicaDTO clinicaDTO) {
        return clinicaService.createClinica(clinicaDTO);
    }

    @PutMapping("/{id}")
    public ClinicaDTO updateClinica(@PathVariable Long id, @RequestBody ClinicaDTO clinicaDTO) {
        return clinicaService.updateClinica(id, clinicaDTO);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteClinica(@PathVariable Long id) {
        clinicaService.deleteClinica(id);
    }

    @GetMapping(value = "/{id}")
    public ClinicaDTO getClinica(@PathVariable Long id) {
        return clinicaService.findClinica(id);
    }

    @GetMapping()
    public List<ClinicaDTO> getClinicas() {
        return clinicaService.findClinicas();
    }
}


