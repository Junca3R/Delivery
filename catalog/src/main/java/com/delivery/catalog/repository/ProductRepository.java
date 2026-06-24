package com.delivery.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.delivery.catalog.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {// JpaRepository es una interfaz que nos permite realizar operaciones CRUD
                                                                        // (Create, Read, Update, Delete) en la base de datos. El primer parámetro es
                                                                        // la entidad que vamos a manejar y el segundo parámetro es el tipo de dato de la
                                                                        // clave primaria de la entidad.
}