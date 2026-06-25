package com.delivery.orders.service;

import com.delivery.orders.client.CatalogClient;
import com.delivery.orders.client.CustomerClient;
import com.delivery.orders.dto.CustomerDTO;
import com.delivery.orders.dto.ProductDTO;
import com.delivery.orders.entity.Order;
import com.delivery.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final CatalogClient catalogClient;

    @Override
    public Order createOrder(Order order) {
        // 1. Validar si el cliente existe usando Feign
        CustomerDTO customer = customerClient.getCustomerById(order.getCustomerId());
        if (customer == null) {
            throw new RuntimeException("No se puede crear el pedido porque el cliente no existe.");
        }

        // 2. Validar si el producto existe y obtener sus datos
        ProductDTO product = catalogClient.getProductById(order.getProductId());
        if (product == null) {
            throw new RuntimeException("El producto solicitado no existe.");
        }

        // 3. Validar si hay stock suficiente
        if (product.getStock() < order.getQuantity()) {
            throw new RuntimeException("Stock insuficiente para el producto: " + product.getName());
        }

        // 4. Descontar el stock en el microservicio de catálogo
        catalogClient.updateStock(product.getId(), order.getQuantity());

        // 5. Calcular el total y armar el pedido
        order.setTotalPrice(product.getPrice() * order.getQuantity());
        order.setStatus("PROCESADO");

        // 6. Guardar en la base de datos local de pedidos
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado con ID: " + id));
    }
}