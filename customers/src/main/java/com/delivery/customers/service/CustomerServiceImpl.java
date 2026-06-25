package com.delivery.customers.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.delivery.customers.entity.Customer;
import com.delivery.customers.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service// Indica que esta clase es un servicio de Spring
@RequiredArgsConstructor// Lombok genera un constructor con todos los campos finales
public class CustomerServiceImpl implements CustomerService {// Implementación de la interfaz service CustomerService

    private final CustomerRepository customerRepository;

    @Override//anotacion que indica que este metodo sobreescribe un metodo de la interfaz
    public List<Customer> getAllCustomers() {// Metodo para obtener todos los clientes
        return customerRepository.findAll();// Llama al método findAll() del repositorio para obtener todos los clientes
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id)//Busca un cliente por su ID en el repositorio
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));// Si no se encuentra el cliente, lanza una excepción con un mensaje de error
    }

    @Override
    public Customer createCustomer(Customer customer) {// Metodo para crear un nuevo cliente
        if (customerRepository.existsByEmail(customer.getEmail())) {// Verifica si el correo electrónico del cliente ya existe en la base de datos
            throw new RuntimeException("El correo electrónico ya está registrado: " + customer.getEmail());// Si el correo electrónico ya existe, lanza una excepción con un mensaje de error
        }
        return customerRepository.save(customer);// Llama al método save() del repositorio para guardar el nuevo cliente en la base de datos
    }

    @Override
    public Customer updateCustomer(Long id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id)//Busca un cliente por su ID en el repositorio
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));// Si no se encuentra el cliente, lanza una excepción con un mensaje de error en tiempo de ejecucion
        existingCustomer.setName(customer.getName());// Actualiza el nombre
        existingCustomer.setEmail(customer.getEmail());// Actualiza el correo electrónico
        return customerRepository.save(existingCustomer);//guarda
    }

    @Override
    public Customer deleteCustomer(Long id) {
        Customer customer = customerRepository.findById(id)//busca un cliente por su ID en el repositorio
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));//orelseThrow lanza una excepción si no se encuentra el cliente con el ID proporcionado una RuntimeException con un mensaje de error
        customerRepository.delete(customer);//elimina
        return customer;//devuelve el cliente eliminado
    }

}