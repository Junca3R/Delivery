package com.delivery.orders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients// anotacion para habilitar el uso de Feign en la
//  aplicacion, feign es un cliente HTTP declarativo que simplifica la comunicacion entre microservicios
@SpringBootApplication
public class MsOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsOrdersApplication.class, args);
	}

}
