package com.delivery.orders.service;

import java.util.List;

import com.delivery.orders.entity.Order;
//servicio de ordenes que define los metodos para crear, obtener y listar ordenes
public interface OrderService {
    Order createOrder(Order order);// Metodo para crear una nueva orden
    List<Order> getAllOrders();// Metodo para obtener todas las ordenes
    Order getOrderById(Long id);// Metodo para obtener una orden por su ID
}