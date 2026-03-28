package com.petcare.serviciocitas.controller;

import com.petcare.serviciocitas.dto.CitaDTO;
import com.petcare.serviciocitas.model.Cita;
import com.petcare.serviciocitas.service.CitaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService citaService;

    public CitaController(CitaService citaService) {
        this.citaService = citaService;
    }

    @GetMapping
    public ResponseEntity<List<Cita>> obtenerTodas() {
        return ResponseEntity.ok(citaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtenerPorId(@PathVariable Long id) {
        return citaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Cita>> obtenerPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(citaService.obtenerPorEstado(estado));
    }

    @GetMapping("/veterinario/{veterinario}")
    public ResponseEntity<List<Cita>> obtenerPorVeterinario(@PathVariable String veterinario) {
        return ResponseEntity.ok(citaService.obtenerPorVeterinario(veterinario));
    }

    @PostMapping
    public ResponseEntity<Cita> crear(@RequestBody CitaDTO citaDTO) {
        Cita creada = citaService.crear(citaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }
}
