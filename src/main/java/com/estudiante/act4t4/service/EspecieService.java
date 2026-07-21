package com.estudiante.act4t4.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estudiante.act4t4.dto.EspecieDTO;
import com.estudiante.act4t4.exception.ResourceNotFoundException;
import com.estudiante.act4t4.model.Especie;
import com.estudiante.act4t4.repository.EspecieRepository;

@Service
public class EspecieService {

    private final EspecieRepository especieRepository;

    public EspecieService(EspecieRepository especieRepository) {
        this.especieRepository = especieRepository;
    }

    public List<EspecieDTO> listarTodas() {
        return especieRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public Especie buscarEntidadPorId(Long id) {
        return especieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especie no encontrada con id: " + id));
    }

    private EspecieDTO toDTO(Especie especie) {
        return new EspecieDTO(especie.getId(), especie.getNombre());
    }
}
