package com.example.orders.repository;

import com.example.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for {@link Order} persistence operations.
 * <p>
 * Extends {@link JpaRepository} to provide CRUD operations and paging/sorting out of the box.
 * </p>
 *
 * @since 1.0
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // No custom methods required for the basic CRUD use-case.
}
