package com.estudiante.act4t4.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudiante.act4t4.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);

    boolean existsByUsername(String username);
}
