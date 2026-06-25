package com.delivery.orders.dto;

import lombok.Data;

@Data
public class CustomerDTO {// clase DTO para representar la informacion del cliente que se recibe desde el microservicio de clientes
    private Long id;// identificador unico del cliente
    private String name;// nombre del cliente
    private String email;// correo electronico del cliente
}