package com.estudiante.act4t4.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudiante.act4t4.dto.EspecieDTO;
import com.estudiante.act4t4.service.EspecieService;

@RestController
@RequestMapping("/api/especies")
public class EspecieController {

    private final EspecieService especieService;

    public EspecieController(EspecieService especieService) {
        this.especieService = especieService;
    }

    @GetMapping
    public ResponseEntity<List<EspecieDTO>> listar() {
        return ResponseEntity.ok(especieService.listarTodas());
    }
}
