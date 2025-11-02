package com.codemainlabs.order.service;

import com.codemainlabs.order.model.Order;
import com.codemainlabs.order.repository.OrderRepository;
import com.codemainlabs.order.util.Status;
import com.codemainlabs.order.util.exception.OrderNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public Page<Order> findAllOrdersOrderedByIdDesc(Pageable pageable) {
        if (pageable.getPageSize() > 20) {
            pageable = PageRequest.of(pageable.getPageNumber(), 20, Sort.by(Sort.Direction.DESC, "id"));
        } else {
            pageable = PageRequest.of(
                    pageable.getPageNumber(),
                    pageable.getPageSize(),
                    Sort.by(Sort.Direction.DESC, "id")
            );
        }
        return orderRepository.findAll(pageable);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
    }

    public Order createOrder(Order order) {
        order.setStatus(Status.IN_PROGRESS);
        return orderRepository.save(order);
    }

    public Order cancelOrder(Long id) {
        Order order = getOrderById(id);
        if (order.getStatus() == Status.IN_PROGRESS) {
            order.setStatus(Status.CANCELLED);
            return orderRepository.save(order);
        } else {
            throw new IllegalStateException("You can't cancel an order that is in the " + order.getStatus() + " status");
        }
    }

    public Order completeOrder(Long id) {
        Order order = getOrderById(id);
        if (order.getStatus() == Status.IN_PROGRESS) {
            order.setStatus(Status.COMPLETED);
            return orderRepository.save(order);
        } else {
            throw new IllegalStateException("You can't complete an order that is in the " + order.getStatus() + " status");
        }
    }
}
