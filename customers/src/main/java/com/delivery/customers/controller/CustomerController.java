package com.delivery.customers.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.customers.entity.Customer;
import com.delivery.customers.service.CustomerService;

import lombok.RequiredArgsConstructor;
@RestController// Indica que esta clase es un controlador de Spring y que sus métodos devolverán respuestas HTTP
@RequestMapping("/api/v1/customers")//ruta para acceder a los metodos de la clase
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;// Inyección de dependencias del servicio CustomerService porque una inyeccion 
    // de dependencias es un patrón de diseño que permite a un objeto recibir sus dependencias de otro objeto en lugar de crearlas por sí mismo. 
    // Esto ayuda a reducir el acoplamiento entre los objetos y facilita la prueba y el mantenimiento del código.

    @GetMapping// Indica que este método manejará solicitudes HTTP GET a la ruta "/api/v1/customers"
    public ResponseEntity<List<Customer>> getAllCustomers() {//devuelvbe una lista con todos los clientes respondiendo http 200 OK con la lista de clientes en el cuerpo de la respuesta
        return ResponseEntity.ok(customerService.getAllCustomers());// Llama al método getAllCustomers() del servicio y devuelve la lista de clientes con un código de estado HTTP 200 OK
    }

    @GetMapping("/{id}")//metodo para obtener cliente por id
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {// @PathVariable nos permite obtener el valor de la variable id de la ruta
        return ResponseEntity.ok(customerService.getCustomerById(id));// Llama al método getCustomerById() del servicio y devuelve el cliente con un código de estado HTTP 200 OK
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {//@RequestBody nos permite obtener el cuerpo de la petición HTTP, en este caso nos permite obtener el cliente que queremos crear
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.createCustomer(customer));// Llama al método createCustomer() del servicio y devuelve el cliente creado con un código de estado HTTP 201 Created
    }
    @PutMapping("/{id}")//metodo para actualizar cliente por id
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {//@path permite actualiar un cliente por el id
        return ResponseEntity.ok(customerService.updateCustomer(id, customer));// Llama al método updateCustomer() del servicio y devuelve el cliente actualizado con un código de estado HTTP 200 OK
    }

    @DeleteMapping("/{id}")//metodo para eliminar cliente por id
    public ResponseEntity<Customer> deleteCustomer(@PathVariable Long id) {//@path permite eliminar un cliente por el id
        return ResponseEntity.ok(customerService.deleteCustomer(id));// Llama al método deleteCustomer() del servicio y devuelve el cliente eliminado con un código de estado HTTP 200 OK 
    }
        
}