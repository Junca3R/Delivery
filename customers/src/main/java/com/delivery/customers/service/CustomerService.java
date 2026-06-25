package com.delivery.customers.service;

import java.util.List;

import com.delivery.customers.entity.Customer;
// Interfaz que define los métodos del servicio de clientes
public interface CustomerService {
    List<Customer> getAllCustomers();// Metodo para obtener todos los clientes
    Customer getCustomerById(Long id);// Metodo para obtener un cliente por su ID
    Customer createCustomer(Customer customer);// Metodo para crear un nuevo cliente
    Customer updateCustomer(Long id, Customer customer);// metodo para actualizar un cliente existente
    Customer deleteCustomer(Long id);// Metodo para eliminar un cliente por su ID
}