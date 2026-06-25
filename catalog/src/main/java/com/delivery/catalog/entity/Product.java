package com.delivery.catalog.entity;
// mapea la tabla de la base de datos

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;





@Entity// entidad en la base de datos(tabla)
@Table(name = "products")// nombre de la tabla en la base de datos
@Data //generacion e datos automaticamente
@NoArgsConstructor//contructor vacio
@AllArgsConstructor//contructor con todos los atributos


public class Product {
    
    @Id// calve primaria de la tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)//autoincrementable
    private Long id;// atributo de la tabla

    private String name;
    private String description;
    private Double price;
    private Integer stock;


    // creo que lombok no me genra los metodos get y set de los atributos, por eso los creo manualmente
public String getName() {
    return name;
}

public Integer getStock() {
    return stock;
}

public void setStock(Integer stock) {
    this.stock = stock;
}



}
