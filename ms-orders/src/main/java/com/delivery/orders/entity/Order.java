package com.delivery.orders.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//entidad de la base de datos (tabla orders)
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long productId;
    private Integer quantity;
    private Double totalPrice;
    private String status; // PENDIENTE, PROCESADO, CANCELADO

    public Long getCustomerId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Long getProductId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Integer getQuantity() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

   
    public void setStatus(String procesado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void setTotalPrice(double d) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}