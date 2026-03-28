package com.petcare.serviciopedidos.service;

import com.petcare.serviciopedidos.dto.PedidoDTO;
import com.petcare.serviciopedidos.model.Pedido;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class PedidoService {

    private final List<Pedido> pedidos = new ArrayList<>();
    private final AtomicLong contadorId = new AtomicLong(9);

    public PedidoService() {
        pedidos.add(new Pedido(1L, "Alimento Premium Perro 15kg", "Alimento", 2, 25990.0, 51980.0, "Pendiente", "Maria Lopez", "2026-03-20"));
        pedidos.add(new Pedido(2L, "Arena Sanitaria Gato 10kg", "Higiene", 3, 8990.0, 26970.0, "Enviado", "Carlos Diaz", "2026-03-18"));
        pedidos.add(new Pedido(3L, "Collar Antipulgas Perro", "Salud", 1, 12990.0, 12990.0, "Entregado", "Ana Torres", "2026-03-15"));
        pedidos.add(new Pedido(4L, "Juguete Mordedor Resistente", "Juguete", 4, 5990.0, 23960.0, "Pendiente", "Pedro Sanchez", "2026-03-22"));
        pedidos.add(new Pedido(5L, "Shampoo Medicado Gato", "Higiene", 2, 7490.0, 14980.0, "Enviado", "Laura Gutierrez", "2026-03-19"));
        pedidos.add(new Pedido(6L, "Cama Ortopedica Perro Grande", "Accesorios", 1, 34990.0, 34990.0, "Entregado", "Jorge Martinez", "2026-03-10"));
        pedidos.add(new Pedido(7L, "Transportador Gato Mediano", "Accesorios", 1, 19990.0, 19990.0, "Cancelado", "Sofia Herrera", "2026-03-21"));
        pedidos.add(new Pedido(8L, "Snack Dental Perro x30", "Alimento", 5, 6990.0, 34950.0, "Pendiente", "Diego Fernandez", "2026-03-25"));
    }

    public List<Pedido> obtenerTodos() {
        return pedidos;
    }

    public Optional<Pedido> obtenerPorId(Long id) {
        return pedidos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public List<Pedido> obtenerPorEstado(String estado) {
        return pedidos.stream()
                .filter(p -> p.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }

    public List<Pedido> obtenerPorCategoria(String categoria) {
        return pedidos.stream()
                .filter(p -> p.getCategoriaProducto().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    public Pedido crear(PedidoDTO dto) {
        Pedido pedido = new Pedido();
        pedido.setId(contadorId.getAndIncrement());
        pedido.setNombreProducto(dto.getNombreProducto());
        pedido.setCategoriaProducto(dto.getCategoriaProducto());
        pedido.setCantidad(dto.getCantidad());
        pedido.setPrecioUnitario(dto.getPrecioUnitario());
        pedido.setPrecioTotal(dto.getPrecioUnitario() * dto.getCantidad());
        pedido.setNombreCliente(dto.getNombreCliente());
        pedido.setFechaPedido(dto.getFechaPedido());
        pedido.setEstado("Pendiente");
        pedidos.add(pedido);
        return pedido;
    }
}
