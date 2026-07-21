package com.estudiante.act4t4.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponseDTO {

    private LocalDateTime timestamp = LocalDateTime.now();
    private int status;
    private String error;
    private List<String> mensajes;

    public ErrorResponseDTO() {
    }

    public ErrorResponseDTO(int status, String error, List<String> mensajes) {
        this.status = status;
        this.error = error;
        this.mensajes = mensajes;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getMensajes() {
        return mensajes;
    }

    public void setMensajes(List<String> mensajes) {
        this.mensajes = mensajes;
    }
}
