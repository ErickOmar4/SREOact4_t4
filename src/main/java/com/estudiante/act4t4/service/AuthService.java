package com.estudiante.act4t4.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.estudiante.act4t4.dto.AuthResponseDTO;
import com.estudiante.act4t4.dto.LoginRequestDTO;
import com.estudiante.act4t4.dto.RegisterRequestDTO;
import com.estudiante.act4t4.model.Role;
import com.estudiante.act4t4.model.Usuario;
import com.estudiante.act4t4.repository.UsuarioRepository;
import com.estudiante.act4t4.security.JwtService;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public AuthService(UsuarioRepository usuarioRepository,
                        PasswordEncoder passwordEncoder,
                        AuthenticationManager authenticationManager,
                        JwtService jwtService) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public AuthResponseDTO registrar(RegisterRequestDTO request) {
        if (usuarioRepository.existsByUsername(request.getUsername())) {
            throw new IllegalArgumentException("El username ya está en uso");
        }

        Usuario usuario = new Usuario();
        usuario.setUsername(request.getUsername());
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        usuario.setRole(Role.ROLE_USER);
        usuarioRepository.save(usuario);

        String token = jwtService.generarToken(usuario.getUsername());
        return new AuthResponseDTO(usuario.getUsername(), token);
    }

    public AuthResponseDTO login(LoginRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

        String token = jwtService.generarToken(request.getUsername());
        return new AuthResponseDTO(request.getUsername(), token);
    }
}
