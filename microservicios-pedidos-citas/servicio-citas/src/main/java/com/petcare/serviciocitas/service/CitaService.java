package com.petcare.serviciocitas.service;

import com.petcare.serviciocitas.dto.CitaDTO;
import com.petcare.serviciocitas.model.Cita;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class CitaService {

    private final List<Cita> citas = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(9);

    public CitaService() {
        citas.add(new Cita(1L, "Rocky", "Perro", "Maria Lopez", "+56912345678", "Consulta general", "Dr. Ramirez", "2026-04-01 10:00", "Programada"));
        citas.add(new Cita(2L, "Michi", "Gato", "Carlos Diaz", "+56923456789", "Vacunacion", "Dra. Soto", "2026-04-01 11:30", "Programada"));
        citas.add(new Cita(3L, "Luna", "Perro", "Ana Torres", "+56934567890", "Cirugia menor", "Dr. Ramirez", "2026-03-28 09:00", "Completada"));
        citas.add(new Cita(4L, "Simba", "Gato", "Pedro Sanchez", "+56945678901", "Desparasitacion", "Dra. Muñoz", "2026-04-02 15:00", "Programada"));
        citas.add(new Cita(5L, "Max", "Perro", "Laura Gutierrez", "+56956789012", "Control dental", "Dr. Ramirez", "2026-03-25 14:00", "Completada"));
        citas.add(new Cita(6L, "Pelusa", "Conejo", "Jorge Martinez", "+56967890123", "Consulta general", "Dra. Soto", "2026-04-03 10:00", "Programada"));
        citas.add(new Cita(7L, "Thor", "Perro", "Sofia Herrera", "+56978901234", "Vacunacion", "Dra. Muñoz", "2026-03-30 16:00", "Cancelada"));
        citas.add(new Cita(8L, "Nala", "Gato", "Diego Fernandez", "+56989012345", "Esterilizacion", "Dr. Ramirez", "2026-04-05 09:30", "Programada"));
    }

    public List<Cita> obtenerTodas() {
        return citas;
    }

    public Optional<Cita> obtenerPorId(Long id) {
        return citas.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public List<Cita> obtenerPorEstado(String estado) {
        return citas.stream()
                .filter(c -> c.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }

    public List<Cita> obtenerPorVeterinario(String veterinario) {
        return citas.stream()
                .filter(c -> c.getVeterinario().toLowerCase().contains(veterinario.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Cita crear(CitaDTO dto) {
        Cita cita = new Cita();
        cita.setId(contadorId.getAndIncrement());
        cita.setNombreMascota(dto.getNombreMascota());
        cita.setTipoMascota(dto.getTipoMascota());
        cita.setNombreDueno(dto.getNombreDueno());
        cita.setTelefonoDueno(dto.getTelefonoDueno());
        cita.setServicio(dto.getServicio());
        cita.setVeterinario(dto.getVeterinario());
        cita.setFechaHora(dto.getFechaHora());
        cita.setEstado("Programada");
        citas.add(cita);
        return cita;
    }
}
