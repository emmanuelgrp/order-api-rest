package com.codemainlabs.order.util.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.codemainlabs.order.controller.OrderController;
import com.codemainlabs.order.model.Order;
import com.codemainlabs.order.util.Status;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {

    @Override
    public EntityModel<Order> toModel(Order order) {

        EntityModel<Order> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrderController.class).all(null)).withRel("orders"));

        if (order.getStatus() == Status.IN_PROGRESS) {
            orderModel.add(linkTo(methodOn(OrderController.class).cancel(order.getId())).withRel("cancel").withType("DELETE").withTitle("Cancel Order"));
            orderModel.add(linkTo(methodOn(OrderController.class).complete(order.getId())).withRel("complete").withType("PUT").withTitle("Complete Order"));
        }

        return orderModel;
    }

}
