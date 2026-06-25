package com.delivery.customers.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//entidad de la base de datos (tabla customers)

@Entity// entidad de labase de datos
@Table(name = "customers")//
@Data//Lombok genera los metodos get y set
@NoArgsConstructor//
@AllArgsConstructor
public class Customer {

    @Id//clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrementable
    private Long id;//atrubuto de la tabla

    private String name;
    private String email;
    private String phone;
    private String address;
}