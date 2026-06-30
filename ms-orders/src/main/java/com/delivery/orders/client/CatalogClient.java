package com.delivery.orders.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.delivery.orders.dto.ProductDTO;

@FeignClient(name = "ms-catalog", url = "http://ms-catalog:8081")// anotacion para indicar que esta interfaz es un cliente Feign que se 
// comunica con el microservicio de catalogo
public interface CatalogClient {//

    @GetMapping("/api/v1/products/{id}")// anotacion para indicar que este metodo realiza una peticion GET al endpoint /api/v1/products/{id} del microservicio de catalogo
    ProductDTO getProductById(@PathVariable("id") Long id);// metodo para obtener la informacion de un producto por su id, el id se pasa como parametro en la URL

    @PutMapping("/api/v1/products/{id}/stock")//anotacion para indicar que este metodo realiza una peticion PUT al endpoint /api/v1/products/{id}/stock del microservicio de catalogo
    ProductDTO updateStock(@PathVariable("id") Long id, @RequestParam("quantity") Integer quantity);
}