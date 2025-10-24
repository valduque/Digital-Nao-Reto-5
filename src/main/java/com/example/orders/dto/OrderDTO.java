package com.example.orders.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class OrderDTO {

    private Long id;

    @NotBlank
    private String type;

    @NotNull
    private List<String> products;

    @NotNull
    private LocalDate date;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public List<String> getProducts() { return products; }
    public void setProducts(List<String> products) { this.products = products; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
}
