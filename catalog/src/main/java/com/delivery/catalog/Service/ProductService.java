package com.delivery.catalog.Service;
//
import java.util.List;

import com.delivery.catalog.entity.Product;// importamos la clase Product para poder utilizarla en los metodos de la interfaz

// interfaz que nos permite definir los metodos que vamos a implementar en la clase ProductServiceImpl

public interface ProductService {
List<Product> getAllProducts();// metodo que nos permite obtener todos los productos de la base de datos
Product getProductById(Long id);// metodo que nos permite obtener un producto por su id
Product createProduct(Product product);// metodo que nos permite crear un producto
Product updateStock(Long id, Integer quantity);// metodo que nos permite actualizar el stock de un producto
Product deleteProduct(Long id);// metodo que nos permite eliminar un producto


    
}
