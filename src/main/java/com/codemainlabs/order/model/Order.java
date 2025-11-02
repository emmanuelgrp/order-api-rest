package com.codemainlabs.order.model;

import com.codemainlabs.order.util.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "CUSTOMER_ORDER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private Status status;
}
