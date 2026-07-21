package com.estudiante.act4t4.dto;

public class EspecieDTO {

    private Long id;
    private String nombre;

    public EspecieDTO() {
    }

    public EspecieDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
