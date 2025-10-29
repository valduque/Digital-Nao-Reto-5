package com.example.orders.controller;

import com.example.orders.dto.OrderDTO;
import com.example.orders.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller that manages CRUD operations for orders.
 * <p>
 * Provides endpoints to create, retrieve, update, and delete orders.
 * Each order is represented by an {@link OrderDTO}.
 * </p>
 *
 * <p><strong>Base URL:</strong> {@code /api/orders}</p>
 *
 * @author
 * @version 1.0
 */
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService service;

    /**
     * Constructs the controller with the specified {@link OrderService}.
     *
     * @param service the service used to handle business logic for orders
     */
    public OrderController(OrderService service) {
        this.service = service;
    }

    /**
     * Retrieves all existing orders.
     *
     * @return a list of {@link OrderDTO} representing all orders in the database
     */
    @Operation(summary="Get all orders", description="Brings back orders for a specific user")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "200", description = "Orders brought successfully")
    })

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return service.findAll();
    }

    /**
     * Retrieves a specific order by its ID.
     *
     * @param id the ID of the order to retrieve
     * @return {@link ResponseEntity} containing the order if found, or 404 if not found
     */

    @Operation(summary="Get an order", description="Gets an order for a specific user")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "204", description = "Order retrieved successfully")
    })
    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> getOrder(@PathVariable Long id) {
        OrderDTO dto = service.findById(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    /**
     * Creates a new order.
     *
     * @param dto the order data to create, validated using {@link Valid}
     * @return {@link ResponseEntity} containing the created {@link OrderDTO}
     */

    @Operation(summary="Create a new order", description="Creates a new order for a specific user")
        @ApiResponses(value ={
                @ApiResponse(responseCode = "201", description = "Order created successfully")
        })


    @PostMapping
    public ResponseEntity<OrderDTO> createOrder(@Valid @RequestBody OrderDTO dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    /**
     * Updates an existing order.
     *
     * @param id  the ID of the order to update
     * @param dto the updated order data, validated using {@link Valid}
     * @return {@link ResponseEntity} containing the updated {@link OrderDTO}, or 404 if not found
     */

    @Operation(summary="Update an order", description="Updates an order for a specific user")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "204", description = "Order updated successfully")
    })
    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> updateOrder(@PathVariable Long id, @Valid @RequestBody OrderDTO dto) {
        OrderDTO updated = service.update(id, dto);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    /**
     * Deletes an existing order by its ID.
     *
     * @param id the ID of the order to delete
     * @return {@link ResponseEntity} with status 204 (No Content)
     */

    @Operation(summary="Delete an order", description="Deletes an order for a specific user")
    @ApiResponses(value ={
            @ApiResponse(responseCode = "204", description = "Order deleted successfully")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
