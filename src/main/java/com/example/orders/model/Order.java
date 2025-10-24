package com.example.orders.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

/**
 * JPA entity representing an order.
 * <p>
 * Maps to the table {@code orders} and stores the order's type, products and date.
 * The products are stored in a separate collection table {@code order_products}.
 * </p>
 *
 * @since 1.0
 */
@Entity
@Table(name = "orders")
public class Order {

    /**
     * Primary key identifier for the order.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Type or classification of the order.
     */
    @NotBlank
    private String type;

    /**
     * Iterable list of product names included in the order.
     * Stored as an {@code ElementCollection} in {@code order_products} table.
     */
    @ElementCollection
    @CollectionTable(name = "order_products", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "product")
    private List<String> products;

    /**
     * Date when the order was created.
     */
    @NotNull
    private LocalDate date;

    // Getters and setters

    /**
     * Returns the order id.
     *
     * @return the id
     */
    public Long getId() { return id; }

    /**
     * Sets the order id.
     *
     * @param id the id to set
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
     * @param type the type to set
     */
    public void setType(String type) { this.type = type; }

    /**
     * Returns the products list.
     *
     * @return the products
     */
    public List<String> getProducts() { return products; }

    /**
     * Sets the products list.
     *
     * @param products the products to set
     */
    public void setProducts(List<String> products) { this.products = products; }

    /**
     * Returns the date of the order.
     *
     * @return the date
     */
    public LocalDate getDate() { return date; }

    /**
     * Sets the date of the order.
     *
     * @param date the date to set
     */
    public void setDate(LocalDate date) { this.date = date; }
}
