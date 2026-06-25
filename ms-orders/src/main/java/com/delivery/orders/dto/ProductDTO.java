package com.delivery.orders.dto;

import lombok.Data;

@Data
public class ProductDTO {// clase DTO para representar la informacion del producto que se recibe desde el microservicio de productos
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
}