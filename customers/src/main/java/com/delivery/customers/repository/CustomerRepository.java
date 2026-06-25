package com.delivery.customers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.customers.entity.Customer;

@Repository// Indica que esta interfaz es un repositorio de Spring Data JPA
public interface CustomerRepository extends JpaRepository<Customer, Long> {// JpaRepository proporciona métodos CRUD y de paginación para la entidad Customer
    // Podemos añadir un método personalizado para validar correos únicos más adelante
    boolean existsByEmail(String email);// Método para verificar si un correo electrónico ya existe en la base de datos
}