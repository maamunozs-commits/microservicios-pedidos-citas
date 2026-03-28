package com.petcare.serviciopedidos.controller;

import com.petcare.serviciopedidos.dto.PedidoDTO;
import com.petcare.serviciopedidos.model.Pedido;
import com.petcare.serviciopedidos.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> obtenerTodos() {
        return ResponseEntity.ok(pedidoService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pedido> obtenerPorId(@PathVariable Long id) {
        return pedidoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Pedido>> obtenerPorEstado(@PathVariable String estado) {
        return ResponseEntity.ok(pedidoService.obtenerPorEstado(estado));
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Pedido>> obtenerPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(pedidoService.obtenerPorCategoria(categoria));
    }

    @PostMapping
    public ResponseEntity<Pedido> crear(@RequestBody PedidoDTO pedidoDTO) {
        Pedido creado = pedidoService.crear(pedidoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }
}
