package com.delivery.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.orders.entity.Order;
// interfaz de repositorio para la entidad Order, que extiende JpaRepository para proporcionar metodos CRUD y de consulta
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}