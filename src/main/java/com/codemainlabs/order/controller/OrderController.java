package com.codemainlabs.order.controller;
import com.codemainlabs.order.model.Order;
import com.codemainlabs.order.service.OrderService;
import com.codemainlabs.order.util.hateoas.OrderModelAssembler;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderModelAssembler assembler;

    @GetMapping("/orders")
    public CollectionModel<EntityModel<Order>> all(Pageable pageable) {
        Page<Order> orderPage = orderService.findAllOrdersOrderedByIdDesc(pageable);

        List<EntityModel<Order>> orders = orderPage.getContent().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(orders,
                linkTo(methodOn(OrderController.class).all(pageable)).withSelfRel());
    }

    @GetMapping("/orders/{id}")
    public EntityModel<Order> one(@PathVariable Long id) {
        return assembler.toModel(orderService.getOrderById(id));
    }

    @PostMapping("/orders")
    public EntityModel<Order> newOrder(@RequestBody Order order) {
        return assembler.toModel(orderService.createOrder(order));
    }

    @DeleteMapping("/orders/{id}/cancel")
    public EntityModel<Order> cancel(@PathVariable Long id) {
        return assembler.toModel(orderService.cancelOrder(id));
    }

    @PutMapping("/orders/{id}/complete")
    public EntityModel<Order> complete(@PathVariable Long id) {
        return assembler.toModel(orderService.completeOrder(id));
    }
}
