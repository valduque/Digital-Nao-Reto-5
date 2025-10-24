package com.example.orders.service;

import com.example.orders.dto.OrderDTO;
import com.example.orders.model.Order;
import com.example.orders.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service layer for handling business logic related to {@link Order} entities.
 * <p>
 * This class provides methods to perform CRUD operations using the
 * {@link OrderRepository} and maps between {@link Order} and {@link OrderDTO}.
 * </p>
 *
 * @since 1.0
 */
@Service
public class OrderService {

    private final OrderRepository repository;

    /**
     * Constructs an {@code OrderService} with the provided repository.
     *
     * @param repository repository used for persistence operations
     */
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieves all orders from the database and maps them to DTOs.
     *
     * @return a {@link List} of {@link OrderDTO} representing all persisted orders
     */
    public List<OrderDTO> findAll() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    /**
     * Finds a single order by its identifier.
     *
     * @param id the identifier of the order to retrieve
     * @return an {@link OrderDTO} if found, otherwise {@code null}
     */
    public OrderDTO findById(Long id) {
        return repository.findById(id).map(this::toDTO).orElse(null);
    }

    /**
     * Creates a new order from the provided DTO.
     *
     * @param dto the order data transfer object containing the order information
     * @return the created {@link OrderDTO} with generated id
     */
    public OrderDTO create(OrderDTO dto) {
        Order order = toEntity(dto);
        return toDTO(repository.save(order));
    }

    /**
     * Updates an existing order identified by {@code id} with data from {@code dto}.
     *
     * @param id  the id of the order to update
     * @param dto the new data for the order
     * @return the updated {@link OrderDTO} if the order existed, otherwise {@code null}
     */
    public OrderDTO update(Long id, OrderDTO dto) {
        return repository.findById(id).map(order -> {
            order.setType(dto.getType());
            order.setProducts(dto.getProducts());
            order.setDate(dto.getDate());
            return toDTO(repository.save(order));
        }).orElse(null);
    }

    /**
     * Deletes the order with the given id.
     *
     * @param id the id of the order to delete
     */
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Converts an {@link Order} entity to {@link OrderDTO}.
     *
     * @param order the entity to convert
     * @return the mapped {@link OrderDTO}
     */
    private OrderDTO toDTO(Order order) {
        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setType(order.getType());
        dto.setProducts(order.getProducts());
        dto.setDate(order.getDate());
        return dto;
    }

    /**
     * Converts an {@link OrderDTO} to an {@link Order} entity.
     *
     * @param dto the DTO to convert
     * @return the mapped {@link Order} entity
     */
    private Order toEntity(OrderDTO dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setType(dto.getType());
        order.setProducts(dto.getProducts());
        order.setDate(dto.getDate());
        return order;
    }
}
