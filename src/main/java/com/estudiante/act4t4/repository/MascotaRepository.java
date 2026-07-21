package com.estudiante.act4t4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudiante.act4t4.model.Mascota;

public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
