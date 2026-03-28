package com.petcare.serviciocitas.model;

public class Cita {

    private Long id;
    private String nombreMascota;
    private String tipoMascota;
    private String nombreDueno;
    private String telefonoDueno;
    private String servicio;
    private String veterinario;
    private String fechaHora;
    private String estado;

    public Cita() {
    }

    public Cita(Long id, String nombreMascota, String tipoMascota, String nombreDueno,
                String telefonoDueno, String servicio, String veterinario,
                String fechaHora, String estado) {
        this.id = id;
        this.nombreMascota = nombreMascota;
        this.tipoMascota = tipoMascota;
        this.nombreDueno = nombreDueno;
        this.telefonoDueno = telefonoDueno;
        this.servicio = servicio;
        this.veterinario = veterinario;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getNombreDueno() {
        return nombreDueno;
    }

    public void setNombreDueno(String nombreDueno) {
        this.nombreDueno = nombreDueno;
    }

    public String getTelefonoDueno() {
        return telefonoDueno;
    }

    public void setTelefonoDueno(String telefonoDueno) {
        this.telefonoDueno = telefonoDueno;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(String veterinario) {
        this.veterinario = veterinario;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
