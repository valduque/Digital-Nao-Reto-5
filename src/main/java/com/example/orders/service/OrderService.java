package com.example.orders.service;

import com.example.orders.dto.OrderDTO;
import com.example.orders.model.Order;
import com.example.orders.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<OrderDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public OrderDTO findById(Long id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    public OrderDTO create(OrderDTO dto) {
        Order order = toEntity(dto);
        return toDTO(repository.save(order));
    }

    public OrderDTO update(Long id, OrderDTO dto) {
        return repository.findById(id).map(order -> {
            order.setType(dto.getType());
            order.setProducts(dto.getProducts());
            order.setDate(dto.getDate());
            return toDTO(repository.save(order));
        }).orElse(null);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    // Conversión entre Entity y DTO
    private OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setType(order.getType());
        dto.setProducts(order.getProducts());
        dto.setDate(order.getDate());
        return dto;
    }

    private Order toEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setType(dto.getType());
        order.setProducts(dto.getProducts());
        order.setDate(dto.getDate());
        return order;
    }
}
