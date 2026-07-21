package com.estudiante.act4t4.dto;

public class MascotaResponseDTO {

    private Long id;
    private String nombre;
    private Integer edad;
    private EspecieDTO especie;

    public MascotaResponseDTO() {
    }

    public MascotaResponseDTO(Long id, String nombre, Integer edad, EspecieDTO especie) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.especie = especie;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public EspecieDTO getEspecie() {
        return especie;
    }

    public void setEspecie(EspecieDTO especie) {
        this.especie = especie;
    }
}
