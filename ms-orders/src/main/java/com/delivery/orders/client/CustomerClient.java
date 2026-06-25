package com.delivery.orders.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.delivery.orders.dto.CustomerDTO;

// El name es solo un identificador. El url apuntará al puerto de ms-customers (luego se cambiará por Docker)
@FeignClient(name = "ms-customers", url = "http://localhost:8082")// anotacion para indicar que esta interfaz es un cliente Feign que se comunica con el microservicio de clientes
public interface CustomerClient {//

    @GetMapping("/api/v1/customers/{id}")// anotacion para indicar que este metodo realiza una peticion GET al endpoint /api/v1/customers/{id} del microservicio de clientes
    CustomerDTO getCustomerById(@PathVariable("id") Long id);// metodo para obtener la informacion de un cliente por su id, el id se pasa como parametro en la URL
}