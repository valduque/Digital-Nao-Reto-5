package com.example.orders.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * Data Transfer Object (DTO) representing an Order entity.
 * <p>
 * Used to transfer order data between the API layer and the service layer
 * without exposing internal entity implementations.
 * </p>
 *
 * <p>Each order contains:</p>
 * <ul>
 *   <li>{@code id} — unique identifier of the order</li>
 *   <li>{@code type} — description or classification of the order</li>
 *   <li>{@code products} — list of product names included in the order</li>
 *   <li>{@code date} — date when the order was created</li>
 * </ul>
 *
 * <p>Validation is handled via Jakarta Bean Validation annotations.</p>
 *
 * @author
 * @version 1.0
 */
public class OrderDTO {

    /**
     * Unique identifier of the order.
     */
    private Long id;

    /**
     * Type or classification of the order.
     * Cannot be blank.
     */
    @NotBlank
    private String type;

    /**
     * List of product names included in the order.
     * Cannot be null.
     */
    @NotNull
    private List<String> products;

    /**
     * Date when the order was created.
     * Cannot be null.
     */
    @NotNull
    private LocalDate date;

    // ----- Getters and Setters -----

    /**
     * Returns the order ID.
     *
     * @return the order ID
     */
    public Long getId() { return id; }

    /**
     * Sets the order ID.
     *
     * @param id the order ID
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Returns the order type.
     *
     * @return the type
     */
    public String getType() { return type; }

    /**
     * Sets the order type.
     *
     * @param type the type
     */
    public void setType(String type) { this.type = type; }

    /**
     * Returns the list of product names.
     *
     * @return the list of product names
     */
    public List<String> getProducts() { return products; }

    /**
     * Sets the list of product names.
     *
     * @param products the list of product names
     */
    public void setProducts(List<String> products) { this.products = products; }

    /**
     * Returns the creation date of the order.
     *
     * @return the creation date
     */
    public LocalDate getDate() { return date; }

    /**
     * Sets the creation date of the order.
     *
     * @param date the creation date
     */
    public void setDate(LocalDate date) { this.date = date; }
}
