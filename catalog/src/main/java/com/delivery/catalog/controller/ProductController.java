package com.delivery.catalog.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.delivery.catalog.Service.ProductService;
import com.delivery.catalog.entity.Product;

import lombok.RequiredArgsConstructor;

@RestController// anotacion que nos permite manejar las peticiones HTTP
@RequestMapping("/api/v1/products")// ruta base para todas las peticiones relacionadas con los productos
@RequiredArgsConstructor// Lombok genera el constructor para la inyección de dependencias


// clase que nos permite manejar las peticiones HTTP relacionadas con los productos
public class ProductController {
    private final ProductService productService;// inyeccion de dependencias del servicio de productos

 @GetMapping
 public ResponseEntity<List<Product>> getAllProducts(){//ResponseEntity nos permite manejar las respuestas HTTP, en este caso nos permite devolver una lista de productos
    return ResponseEntity.ok(productService.getAllProducts());//ok nos permite devolver una respuesta HTTP con codigo 200 y el cuerpo de la respuesta es la lista de productos
 }


 @GetMapping("/{id}")// metodo que nos permite obtener un producto por su id
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {// @PathVariable nos permite obtener el valor de la variable id de la ruta
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @PostMapping/// metodo que nos permite crear un producto, (Nueva informacion en la base de datos)
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {// @RequestBody nos permite obtener el cuerpo de la peticion HTTP, en este caso nos permite obtener el producto que queremos crear
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(product));
    }

    @PutMapping("/{id}/stock")// metodo que nos permite actualizar el stock de un producto(actuaizar informacion ya existente en la base de datos)
    public ResponseEntity<Product> updateStock(@PathVariable Long id, @RequestParam Integer quantity) {
        return ResponseEntity.ok(productService.updateStock(id, quantity));
    }

    @DeleteMapping("/{id}")// metodo que nos permite eliminar un producto
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.deleteProduct(id));
    }


    
}




    

