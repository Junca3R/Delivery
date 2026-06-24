package com.delivery.catalog.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.delivery.catalog.entity.Product;
import com.delivery.catalog.repository.ProductRepository;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Service
@Data
@RequiredArgsConstructor // Lombok genera el constructor para la inyección de dependencias
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {// metodo que nos permite obtener todos los productos de la base de datos
        return productRepository.findAll();//findall es un metodo para obtener todos los productos de la base de datos
    }

    @Override
    public Product getProductById(Long id) {//producto por id, si no lo encuentra lanza una excepcion
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));//orElseThrow es un metodo que nos permite lanzar una excepcion si no encuentra el producto
    }

    @Override
    public Product createProduct(Product product) {// metodo que nos permite crear un producto
        return productRepository.save(product);//save es un metodo que nos permite guardar un producto en la base de datos
    }

    @Override
    public Product updateStock(Long id, Integer quantity) {// metodo que nos permite actualizar el stock de un producto
        Product product = getProductById(id);
        
        if (product.getStock() < quantity) {// si el stock es menor a la cantidad que se quiere actualizar lanza una excepcion
            throw new RuntimeException("Stock insuficiente para el producto: " + product.getName());//RuntimeException es una excepcion que nos permite lanzar un error en tiempo de ejecucion
        }
        
        product.setStock(product.getStock() - quantity);// setStock es un metodo que nos permite actualizar el stock de un producto
        return productRepository.save(product);//
    }

    @Override
    public Product deleteProduct(Long id) {// metodo que nos permite eliminar un producto
        Product product = getProductById(id);
        productRepository.delete(product);//
        return product;
    }

}