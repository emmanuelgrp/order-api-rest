package com.codemainlabs.order.repository;

import com.codemainlabs.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
