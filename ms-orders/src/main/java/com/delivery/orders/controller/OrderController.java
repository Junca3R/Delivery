package com.delivery.orders.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.orders.entity.Order;
import com.delivery.orders.service.OrderService;

import lombok.RequiredArgsConstructor;
// Controlador de ordenes que define los endpoints para crear, obtener y listar ordenes
@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping//post mapping para crear una nueva orden, recibe un objeto Order en el cuerpo de la peticion y devuelve un ResponseEntity con el estado CREATED y la orden creada
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createOrder(order));
    }

    @GetMapping///get mapping para obtener todas las ordenes, devuelve un ResponseEntity con el estado OK y la lista de ordenes
    public ResponseEntity<List<Order>> getAllOrders() {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")//get mapping para obtener una orden por su ID, recibe el ID como parametro en la URL y devuelve un ResponseEntity con el estado OK y la orden encontrada
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
}