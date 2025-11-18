package com.example.parcial.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.parcial.service.*;
import com.example.parcial.dto.DoctoresDTO;
import java.util.List;

@RestController
@RequestMapping("/api/entities")
public class DoctoresController {

    @Autowired
    private DoctoresService doctoresService;

    @PostMapping()
    public DoctoresDTO createDoctores(DoctoresDTO entityDTO) {
        return doctoresService.createDoctores(entityDTO);
    }

    @PutMapping()
    public DoctoresDTO updateDoctores(Long id) {
        return doctoresService.updateDoctores(id, null);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteDoctores(@PathVariable Long id) {
        doctoresService.deleteDoctores(id);
    }

    @GetMapping(value = "/{id}")
    public DoctoresDTO getDoctores(@PathVariable Long id) {
        return doctoresService.findDoctoresDTO(id);
    }
    
    @GetMapping()
    public List<DoctoresDTO> getDoctores  () {
        return doctoresService.findDoctoresDTOs();
    }
}
