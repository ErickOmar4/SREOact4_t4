package com.estudiante.act4t4.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.estudiante.act4t4.dto.EspecieDTO;
import com.estudiante.act4t4.dto.MascotaRequestDTO;
import com.estudiante.act4t4.dto.MascotaResponseDTO;
import com.estudiante.act4t4.exception.ResourceNotFoundException;
import com.estudiante.act4t4.model.Especie;
import com.estudiante.act4t4.model.Mascota;
import com.estudiante.act4t4.repository.MascotaRepository;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;
    private final EspecieService especieService;

    public MascotaService(MascotaRepository mascotaRepository, EspecieService especieService) {
        this.mascotaRepository = mascotaRepository;
        this.especieService = especieService;
    }

    public Page<MascotaResponseDTO> listar(Pageable pageable) {
        return mascotaRepository.findAll(pageable).map(this::toDTO);
    }

    public MascotaResponseDTO buscarPorId(Long id) {
        return toDTO(buscarEntidadPorId(id));
    }

    public MascotaResponseDTO crear(MascotaRequestDTO request) {
        Especie especie = especieService.buscarEntidadPorId(request.getEspecieId());

        Mascota mascota = new Mascota();
        mascota.setNombre(request.getNombre());
        mascota.setEdad(request.getEdad());
        mascota.setEspecie(especie);

        return toDTO(mascotaRepository.save(mascota));
    }

    public MascotaResponseDTO actualizar(Long id, MascotaRequestDTO request) {
        Mascota mascota = buscarEntidadPorId(id);
        Especie especie = especieService.buscarEntidadPorId(request.getEspecieId());

        mascota.setNombre(request.getNombre());
        mascota.setEdad(request.getEdad());
        mascota.setEspecie(especie);

        return toDTO(mascotaRepository.save(mascota));
    }

    public void eliminar(Long id) {
        Mascota mascota = buscarEntidadPorId(id);
        mascotaRepository.delete(mascota);
    }

    private Mascota buscarEntidadPorId(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada con id: " + id));
    }

    private MascotaResponseDTO toDTO(Mascota mascota) {
        EspecieDTO especieDTO = new EspecieDTO(mascota.getEspecie().getId(), mascota.getEspecie().getNombre());
        return new MascotaResponseDTO(mascota.getId(), mascota.getNombre(), mascota.getEdad(), especieDTO);
    }
}
